package com.example.dasboard.admin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hakim")
public class Hakim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_hakim;

    private String nama;

    private String pendidikan;

    @Column(name = "masa_kerja")
    private String masaKerja;

    // Getters & Setters
    public Long getId() { return id_hakim; }

    public void setId(Long id_hakim) { this.id_hakim = id_hakim; }

    public String getNama() { return nama; }

    public void setNama(String nama) { this.nama = nama; }

    public String getPendidikan() { return pendidikan; }

    public void setPendidikan(String pendidikan) { this.pendidikan = pendidikan; }

    public String getMasaKerja() { return masaKerja; }

    public void setMasaKerja(String masaKerja) { this.masaKerja = masaKerja; }
}
