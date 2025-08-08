package com.example.dasboard.admin.model;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "hasilsaw")
public class HasilSAW {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hakim_id", nullable = false)
    private Hakim hakim;

    private Double skor;

    private LocalDate tanggal;

    // Getters & Setters
    public Long getId() { return id; }

    public Hakim getHakim() { return hakim; }
    public void setHakim(Hakim hakim) { this.hakim = hakim; }

    public Double getSkor() { return skor; }
    public void setSkor(Double skor) { this.skor = skor; }

    public LocalDate getTanggal() { return tanggal; }
    public void setTanggal(LocalDate tanggal) { this.tanggal = tanggal; }
}
