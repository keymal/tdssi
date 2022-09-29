package com.example.tdssi.controller.init;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class InitControllerImpl implements InitController {


    @Override
    public String login() {

        return "login";
    }

    @Override
    public String index() {
        return "enregistrer_utilisateur";
    }
}
