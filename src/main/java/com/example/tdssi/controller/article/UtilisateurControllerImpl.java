package com.example.tdssi.controller.article;

import com.example.tdssi.dto.UtilisateurRequestDto;
import com.example.tdssi.dto.UtilisateurResponseDto;
import com.example.tdssi.service.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/utilisateur")
@RequiredArgsConstructor

public class UtilisateurControllerImpl implements UtilisateurController {


    //merci
    private final UtilisateurService utilisateurService;

    @Override
    public String utilisateur() {
        return null;
    }

    @Override
    public ResponseEntity<UtilisateurResponseDto> save(@Valid @RequestBody UtilisateurRequestDto dto, HttpServletRequest request) throws MessagingException {
        String siteURL = request.getRequestURL().toString();
        siteURL.replace(request.getServletPath(), "");

        return new ResponseEntity<>(utilisateurService.save(dto, siteURL), HttpStatus.CREATED);

    }

    @Override
    public String verifyUser(@Param("code") String code) {
        if (utilisateurService.verify(code)) {
            return "confirm_user";
        } else {
            return "verify_fail";

        }
    }
}
