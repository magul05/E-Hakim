package com.example.dasboard.admin.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "penilaian")
public class Penilaian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔗 Relasi Many-to-One ke Hakim
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hakim_id", nullable = false) // Foreign key
    private Hakim hakim;

    private Double integritas;
    private Double pengetahuanHukum;
    private Double pengalaman;
    private Double komunikasi;

    private LocalDate tanggal;

    // Constructors
    public Penilaian() {}

    public Penilaian(Hakim hakim, Double integritas, Double pengetahuanHukum,
                     Double pengalaman, Double komunikasi, LocalDate tanggal) {
        this.hakim = hakim;
        this.integritas = integritas;
        this.pengetahuanHukum = pengetahuanHukum;
        this.pengalaman = pengalaman;
        this.komunikasi = komunikasi;
        this.tanggal = tanggal;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public Hakim getHakim() { return hakim; }
    public void setHakim(Hakim hakim) { this.hakim = hakim; }
    public Double getIntegritas() { return integritas; }
    public void setIntegritas(Double integritas) { this.integritas = integritas; }
    public Double getPengetahuanHukum() { return pengetahuanHukum; }
    public void setPengetahuanHukum(Double pengetahuanHukum) { this.pengetahuanHukum = pengetahuanHukum; }
    public Double getPengalaman() { return pengalaman; }
    public void setPengalaman(Double pengalaman) { this.pengalaman = pengalaman; }
    public Double getKomunikasi() { return komunikasi; }
    public void setKomunikasi(Double komunikasi) { this.komunikasi = komunikasi; }
    public LocalDate getTanggal() { return tanggal; }
    public void setTanggal(LocalDate tanggal) { this.tanggal = tanggal; }
}
