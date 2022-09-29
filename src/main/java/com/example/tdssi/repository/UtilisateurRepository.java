package com.example.tdssi.repository;

import com.example.tdssi.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Utilisateur findUtilisateurByEmailIgnoreCase(String email);

    Utilisateur findUtilisateurByVerificationCode(String d);

    Utilisateur findUtilisateurByResetPasswordToken(String reset);

}
