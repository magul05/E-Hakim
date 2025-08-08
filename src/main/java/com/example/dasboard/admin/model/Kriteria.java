package com.example.dasboard.admin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "kriteria")
public class Kriteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "namakriteria")
    private String namakriteria;

    private String bobot;

    // === Getters & Setters ===

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamakriteria() {
        return namakriteria;
    }

    public void setNamakriteria(String namakriteria) {
        this.namakriteria = namakriteria;
    }

    public String getBobot() {
        return bobot;
    }

    public void setBobot(String bobot) {
        this.bobot = bobot;
    }
}
