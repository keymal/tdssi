package com.example.tdssi.controller.article;

import com.example.tdssi.dto.UtilisateurRequestDto;
import com.example.tdssi.dto.UtilisateurResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

public interface UtilisateurController {
    @GetMapping("")
    String utilisateur();


    @PostMapping("/create")
    ResponseEntity<UtilisateurResponseDto> save(UtilisateurRequestDto dto, HttpServletRequest request) throws MessagingException;

    @GetMapping("/verify")
    public String verifyUser( String code);
}
