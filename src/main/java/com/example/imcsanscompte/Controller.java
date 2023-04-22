package com.example.imcsanscompte;

import com.example.imcsanscompte.model.imcSansCompte;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/microserviceenregistrementdonneesSanscompte")
public class Controller {

    // On injecte le service qui gère les opérations CRUD sur les imcSansCompte
    @Autowired
    private imcSansCompteService imcSansCompteServiceRepository;

    // Endpoint qui permet de tester la connexion en envoyant une requête POST
    @PostMapping("/test")
    public ResponseEntity<String> helloPost() {
        return ResponseEntity.status(HttpStatus.OK).body("test");
    }

    // Endpoint qui permet de tester la connexion en envoyant une requête GET
    @GetMapping("/test")
    public ResponseEntity<String> helloGet() {
        return ResponseEntity.status(HttpStatus.OK).body("test");
    }

    // Endpoint qui renvoie la liste complète des imcSansCompte
    @PostMapping("/readimcssompte")
    public ResponseEntity<List<imcSansCompte>> getAllIMCs() {
        return new ResponseEntity<>(imcSansCompteServiceRepository.findAll(), HttpStatus.OK);
    }

    // Endpoint qui permet d'ajouter un enregistrement IMC en envoyant une requête
    @GetMapping("/addimcsscompte")
    public ResponseEntity<imcSansCompte> addIMC(@RequestBody imcSansCompte imcRecord) {
        float imc = imcRecord.getMasse() / (imcRecord.getTaille() * imcRecord.getTaille());
        imcRecord.setImc(imc);
        imcRecord.setDateIMC(LocalDate.now());
        imcSansCompte newImcRecord = imcSansCompteServiceRepository.addImc(imcRecord.getIdentifiant(), imcRecord.getMasse(), imcRecord.getTaille(), imc);
        return ResponseEntity.status(HttpStatus.CREATED).body(newImcRecord);
    }

}
