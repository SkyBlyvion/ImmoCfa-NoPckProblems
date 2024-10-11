package com.cfa.immo.service;

import com.cfa.immo.model.Bien;

import java.util.List;

public interface BienService {
    Bien saveBien(Bien bien);
    Bien updateBien(Bien bien, Long id);
    void deletBien(Long id);
    Bien getById(Long id);
    List<Bien> findAllBiens();

}
