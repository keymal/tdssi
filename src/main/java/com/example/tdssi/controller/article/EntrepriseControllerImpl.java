package com.example.tdssi.controller.article;

import com.example.tdssi.dto.EntrepriseDto;
import com.example.tdssi.service.EntrepriseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/entreprise")
public class EntrepriseControllerImpl {

    EntrepriseService entrepriseService;

    @GetMapping("")
    public String utilisateur(Model model) {
        return "entreprise";
    }

    @RequestMapping(value = "/getInfos", method = RequestMethod.GET)
    public ResponseEntity<EntrepriseDto> getInfos() {

        return new ResponseEntity<>(entrepriseService.get(), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<EntrepriseDto> save(@RequestBody EntrepriseDto dto) {


        return new ResponseEntity<>(entrepriseService.save(dto), HttpStatus.CREATED);

    }
}
