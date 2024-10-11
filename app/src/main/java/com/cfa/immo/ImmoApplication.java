package com.cfa.immo;

import com.cfa.immo.model.Agent;
import com.cfa.immo.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;


@RestController
@SpringBootApplication
public class ImmoApplication {

	@Autowired
	private AgentService agentService;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(){
		return "bonjour le CFA<br/>" +
				"<a href='/about'>about</a><br/>" +
				"<a href='/agents'>liste des agents</a>";
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		return "nous sommes sur l'about<br/><a href='/'>home</a>";
	}

	@RequestMapping(value="/agents", method = RequestMethod.GET)
	public String listAgent(){
		String html = "<h2>Liste des agents immobilier</h2>";
		List<Agent> agents = agentService.findALlAgent();
		Iterator<Agent> iter = agents.iterator();
		html += "<ul>";
		while (iter.hasNext()){
			Agent a = iter.next();
			html += "<li><a href='/agent/"+a.getId()+"'>" + a.getFullName() +"</a></li>";
		}
		html += "</ul>";

		return html;
	}

	@RequestMapping(value="/agent/{id}", method = RequestMethod.GET)
	public String detailAgent(@PathVariable(value = "id") Long id){
		String html = "<h2>Detail agent</h2>";
		Agent agent = agentService.getAgentById(id);
		html += agent.toString();
		return html;
	}

	public static void main(String[] args) {
		SpringApplication.run(ImmoApplication.class, args);
	}

}
