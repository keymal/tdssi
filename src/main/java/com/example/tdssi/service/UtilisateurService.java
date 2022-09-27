package com.example.tdssi.service;

import com.example.tdssi.dto.UtilisateurRequestDto;
import com.example.tdssi.dto.UtilisateurResponseDto;
import com.example.tdssi.model.Utilisateur;

import javax.mail.MessagingException;

public interface UtilisateurService {
    UtilisateurResponseDto save(UtilisateurRequestDto utilisateurRequestDto, String url) throws MessagingException;

    void  sendEmailVerification(Utilisateur utilisateur, String url) throws MessagingException;

    UtilisateurResponseDto findById(Integer id);

    UtilisateurResponseDto findByEmain(String email);

    void delete(Integer id);

    UtilisateurResponseDto update(UtilisateurRequestDto utilisateurRequestDto, Integer id);


}
