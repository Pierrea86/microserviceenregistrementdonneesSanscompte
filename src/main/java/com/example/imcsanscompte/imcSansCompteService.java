package com.example.imcsanscompte;


import com.example.imcsanscompte.model.imcSansCompte;
import com.example.imcsanscompte.model.imcCompteRepo;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class imcSansCompteService {
    @Autowired
    private imcCompteRepo imcSansCompteServiceRepository;

    public void deleteById(Long id) {
        imcSansCompteServiceRepository.deleteById(id);
    }

    public List<imcSansCompte> findAll() {
        return imcSansCompteServiceRepository.findAll();
    }

    public imcSansCompte addImc(String name, Float masse, Float taille, Float imc ) {
        imcSansCompte imcAdd = new imcSansCompte();
        imcAdd.setIdentifiant(name);
        imcAdd.setTaille(taille);
        imcAdd.setDateIMC(LocalDate.now());
        imcAdd.setMasse(masse);
        imcAdd.setImc(imc);
        return imcSansCompteServiceRepository.save(imcAdd);
    }
}
