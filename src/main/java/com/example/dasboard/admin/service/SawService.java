package com.example.dasboard.admin.service;

import com.example.dasboard.admin.model.HasilSAW;
import com.example.dasboard.admin.model.Penilaian;
import com.example.dasboard.admin.model.Kriteria;
import com.example.dasboard.admin.repository.HasilSAWRepository;
import com.example.dasboard.admin.repository.PenilaianRepository;
import com.example.dasboard.admin.repository.KriteriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class SawService {

    @Autowired
    private PenilaianRepository penilaianRepo;

    @Autowired
    private KriteriaRepository kriteriaRepo;

    @Autowired
    private HasilSAWRepository hasilRepo;

    public void hitungDanSimpanKeDatabase() {
        List<Penilaian> data = penilaianRepo.findAll();
        List<Kriteria> kriteriaList = kriteriaRepo.findAll();

        // ✅ Parsing aman dari String ke Double
        Map<String, Double> bobot = new HashMap<>();
        for (Kriteria k : kriteriaList) {
            try {
                String namaKriteria = k.getNamakriteria().toLowerCase().trim();
                Double nilaiBobot = Double.parseDouble(k.getBobot().trim());
                bobot.put(namaKriteria, nilaiBobot);
            } catch (NumberFormatException e) {
                System.err.println("Bobot tidak valid: " + k.getNamakriteria() + " = " + k.getBobot());
            }
        }

        // ✅ Debug bobot
        System.out.println("=== Bobot Digunakan ===");
        bobot.forEach((k, v) -> System.out.println(k + " = " + v));

        // ✅ Maksimal nilai per kriteria
        double maxIntegritas = data.stream().mapToDouble(Penilaian::getIntegritas).max().orElse(1);
        double maxPengetahuan = data.stream().mapToDouble(Penilaian::getPengetahuanHukum).max().orElse(1);
        double maxPengalaman = data.stream().mapToDouble(Penilaian::getPengalaman).max().orElse(1);
        double maxKomunikasi = data.stream().mapToDouble(Penilaian::getKomunikasi).max().orElse(1);

        // ✅ Hapus hasil sebelumnya
        hasilRepo.deleteAll();

        // ✅ Hitung skor SAW untuk setiap penilaian
        for (Penilaian p : data) {
            Double b1 = bobot.get("integritas");
            Double b2 = bobot.get("pengetahuanhukum");
            Double b3 = bobot.get("pengalaman");
            Double b4 = bobot.get("komunikasi");

            // ❗ Skip jika ada bobot null
            if (b1 == null || b2 == null || b3 == null || b4 == null) {
                System.err.println("Ada bobot kriteria yang belum diisi, data di-skip.");
                continue;
            }

            double skor = (
                    (p.getIntegritas() / maxIntegritas) * b1 +
                    (p.getPengetahuanHukum() / maxPengetahuan) * b2 +
                    (p.getPengalaman() / maxPengalaman) * b3 +
                    (p.getKomunikasi() / maxKomunikasi) * b4
            );

            HasilSAW hasil = new HasilSAW();
            hasil.setHakim(p.getHakim());
            hasil.setSkor(skor);
            hasil.setTanggal(LocalDate.now());

            hasilRepo.save(hasil);
        }

        System.out.println("✅ Perhitungan SAW selesai dan disimpan.");
    }

    // ✅ Ambil semua hasil yang sudah dihitung, urut dari skor tertinggi
    public List<HasilSAW> getAllHasilSAW() {
        return hasilRepo.findAll(Sort.by(Sort.Direction.DESC, "skor"));
    }
}
