package com.example.tdssi.controller.init;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface InitController {

    @GetMapping("/login")
    String login();

    @GetMapping(value = {"","/"})
    String index();



}
