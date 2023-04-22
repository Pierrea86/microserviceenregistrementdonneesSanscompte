package com.example.imcsanscompte.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface imcCompteRepo extends JpaRepository<imcSansCompte, Long> {

    List<imcSansCompte> findAll();

    List<imcSansCompte> findByIdentifiant(String name); // cette donction à implémenter sert à retrouver l'utilisateur par son username dans UserService (avec  l'implementation de l'interface UserDetailsService)

    void deleteById(Long id);

}
