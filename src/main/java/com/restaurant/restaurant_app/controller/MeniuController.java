package com.restaurant_app.controller;

import com.restaurant_app.model.FelPrincipal;
import com.restaurant_app.service.MeniuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MeniuController {

    private final MeniuService meniuService;

    public MeniuController(MeniuService meniuService) {
        this.meniuService = meniuService;
    }

    // Afișează lista cu feluri de mâncare
    @GetMapping("/meniu")
    public String afiseazaMeniu(Model model) {
        model.addAttribute("feluri", meniuService.getAll());
        return "meniu";  // numele template-ului Thymeleaf (meniu.html)
    }

    // Afișează formularul pentru adăugare fel nou
    @GetMapping("/meniu/adauga")
    public String arataFormularAdaugare(Model model) {
        model.addAttribute("felPrincipal", new FelPrincipal());
        return "adauga-fel";  // numele template-ului Thymeleaf (adauga-fel.html)
    }

    // Preia datele din formular și adaugă felul nou în baza de date
    @PostMapping("/meniu/adauga")
    public String adaugaFel(@ModelAttribute FelPrincipal felPrincipal) {
        meniuService.add(felPrincipal);
        return "redirect:/meniu";  // după adăugare, redirecționează către lista de feluri
    }
}
