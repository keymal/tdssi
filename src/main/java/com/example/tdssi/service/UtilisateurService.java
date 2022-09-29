package com.example.tdssi.service;

import com.example.tdssi.dto.UtilisateurRequestDto;
import com.example.tdssi.dto.UtilisateurResponseDto;
import com.example.tdssi.model.Utilisateur;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface UtilisateurService {
    UtilisateurResponseDto save(UtilisateurRequestDto utilisateurRequestDto, String url) throws MessagingException;

    void sendEmail(String recipientEmail, String link)
            throws MessagingException, UnsupportedEncodingException;

    void  sendEmailVerification(Utilisateur utilisateur, String url) throws MessagingException;

    UtilisateurResponseDto findById(Integer id);

    UtilisateurResponseDto findByEmain(String email);

    void delete(Integer id);

    UtilisateurResponseDto update(UtilisateurRequestDto utilisateurRequestDto, Integer id);


    public boolean verify(String verificationCode);


    void updateResetPasswordToken(String token, String email);

    Utilisateur getByResetPasswordToken(String token);

    void updatePassword(Utilisateur utilisateur, String newPassword);
}
