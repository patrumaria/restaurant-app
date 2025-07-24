package com.restaurant_app.controller;

import com.restaurant_app.model.FelPrincipal;
import com.restaurant_app.service.MeniuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meniu")
public class MeniuRestController {

    @Autowired
    private MeniuService meniuService;

    // Obține toate felurile principale
    @GetMapping
    public List<FelPrincipal> getAllFeluri() {
        return meniuService.getAll();
    }

    // Adaugă un fel nou (din JSON)
    @PostMapping
    public FelPrincipal addFel(@RequestBody FelPrincipal fel) {
        return meniuService.add(fel);
    }

    // Șterge un fel după id
    @DeleteMapping("/{id}")
    public void deleteFel(@PathVariable Long id) {
        meniuService.deleteById(id);
    }

    // Obține feluri cu preț mai mare decât cel dat
    @GetMapping("/pret/{pretMinim}")
    public List<FelPrincipal> getFeluriCuPretMinim(@PathVariable double pretMinim) {
        return meniuService.getFeluriCuPretMaiMareCa(pretMinim);
    }
}
