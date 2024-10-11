FROM ubuntu:latest

# update et install curl, zip, unzip
RUN apt-get update && apt-get install -y curl zip unzip

# install SDKMAN
RUN curl -s "https://get.sdkman.io" | bash

# add sdkman au path
ENV SDKMAN_DIR="/root/.sdkman"
ENV PATH="${PATH}:${SDKMAN_DIR}/bin"

# install JAVA home
RUN bash -c "source ${SDKMAN_DIR}/bin/sdkman-init.sh && sdk install java 17.0.8-tem"

# add java au path
ENV JAVA_HOME="${SDKMAN_DIR}/candidates/java/current"
ENV PATH="${PATH}:${JAVA_HOME}/bin"

# verif de l'install java
RUN java -version

# intall gradel
RUN bash -c "source ${SDKMAN_DIR}/bin/sdkman-init.sh && sdk install gradle"

# add gradel to path
ENV GRADLE_HOME="${SDKMAN_DIR}/candidates/gradle/current"
ENV PATH="${PATH}:${GRADLE_HOME}/bin"

# install springboot cli
RUN bash -c "source ${SDKMAN_DIR}/bin/sdkman-init.sh && sdk install springboot"

# add springboot cli to path
ENV SPRING_HOME="${SDKMAN_DIR}/candidates/springboot/current"
ENV PATH="${PATH}:${SPRING_HOME}/bin"

RUN spring --version

WORKDIR /app

RUN spring init --dependencies=web,data-jpa,thymeleaf,mariadb,devtools,webflux ./

EXPOSE 8181 35729


