package com.restaurant_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@MappedSuperclass
public abstract class Mancare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Numele nu poate fi gol")
    private String nume;

    @Positive(message = "Pretul trebuie sa fie pozitiv")
    private double pret;

    public Mancare() {}

    public Mancare(String nume, double pret) {
        this.nume = nume;
        this.pret = pret;
    }

    public Long getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    // Metodă abstractă pentru polimorfism
    public abstract String getDescriere();
}
