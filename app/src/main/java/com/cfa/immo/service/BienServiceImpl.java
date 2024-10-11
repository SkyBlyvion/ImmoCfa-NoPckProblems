package com.cfa.immo.service;

import com.cfa.immo.model.Bien;
import com.cfa.immo.repository.BienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BienServiceImpl implements BienService {

    @Autowired
    private BienRepository bienRepository;

    @Override
    public Bien saveBien(Bien bien) {
        return bienRepository.save(bien);
    }

    @Override
    public Bien updateBien(Bien bien, Long id) {
        bien.setId(id);
        return bienRepository.save(bien);
    }

    @Override
    public void deletBien(Long id) {
        bienRepository.deleteById(id);
    }

    @Override
    public Bien getById(Long id) {
        return bienRepository.getBienById(id);
    }

    @Override
    public List<Bien> findAllBiens() {
        return bienRepository.findAll();
    }
}
