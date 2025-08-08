package com.example.dasboard.admin.controller;

import com.example.dasboard.admin.model.Kriteria;
import com.example.dasboard.admin.repository.KriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class KriteriaController {

    @Autowired
    private KriteriaRepository kriteriaRepository;

    
    // Tampilkan form tambah kriteria
    @GetMapping("/Kriteria/tambah_kriteria")
    public String showForm(Model model) {
        model.addAttribute("kriteria", new Kriteria());
        return "Kriteria/tambah_kriteria";
    }

    // Simpan kriteria baru
    @PostMapping("/Kriteria/simpan")
    public String simpanKriteria(@ModelAttribute Kriteria kriteria) {
        kriteriaRepository.save(kriteria);
        return "redirect:/Kriteria/tambah_kriteria";
    }

    // Tampilkan daftar kriteria
    @GetMapping("/Kriteria/lihat_kriteria")
    public String daftarKriteria(Model model) {
        List<Kriteria> kriteriaList = kriteriaRepository.findAll();
        model.addAttribute("kriteriaList", kriteriaList);
        return "/Kriteria/lihat_kriteria";
    }

    // Hapus kriteria
   @PostMapping("/Kriteria/delete/{id}")
public String deleteKriteria(@PathVariable Long id) {
    kriteriaRepository.deleteById(id);
    return "redirect:/Kriteria/lihat_kriteria";
}


    // Form edit kriteria
    @GetMapping("/Kriteria/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Kriteria kriteria = kriteriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID tidak ditemukan: " + id));
        model.addAttribute("kriteria", kriteria);
        return "Kriteria/edit_kriteria";
    }

    // Simpan update kriteria
    @PostMapping("Kriteria/edit/{id}")
    public String updateKriteria(@PathVariable Long id, @ModelAttribute Kriteria kriteria) {
        kriteria.setId(id);
        kriteriaRepository.save(kriteria);
        return "redirect:/Kriteria/lihat_kriteria";
    }
}
