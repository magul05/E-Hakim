package com.example.dasboard.admin.controller;

import com.example.dasboard.admin.model.Hakim;
import com.example.dasboard.admin.repository.HakimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TambahHakimController {

    @Autowired
    private HakimRepository hakimRepository;

    @GetMapping("/Hakim/tambah_hakim")
    public String showForm(Model model) {
        model.addAttribute("hakim", new Hakim());
        return "Hakim/tambah_hakim";
    }

    @PostMapping("/Hakim/simpan")
    public String simpanHakim(@ModelAttribute Hakim hakim) {
        hakimRepository.save(hakim);
        return "redirect:/Hakim/tambah_hakim";
    }

    // Method untuk menampilkan daftar hakim
    @GetMapping("/Hakim/lihat_data_hakim")
    public String daftarHakim(Model model) {
        List<Hakim> hakimList = hakimRepository.findAll();
        model.addAttribute("hakimList", hakimList);
        return "Hakim/lihat_data_hakim";
    }

   @PostMapping("/Hakim/delete/{id}")
public String deleteHakim(@PathVariable Long id) {
    hakimRepository.deleteById(id);
    return "redirect:/Hakim/lihat_data_hakim";
}

// Tampilkan halaman edit
@GetMapping("/Hakim/edit/{id}")
public String showEditForm(@PathVariable Long id, Model model) {
    Hakim hakim = hakimRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID tidak ditemukan: " + id));
    model.addAttribute("hakim", hakim);
    return "Hakim/edit_hakim";  // Ini file Thymeleaf untuk form edit
}

// Proses update
@PostMapping("/Hakim/edit/{id}")
public String updateHakim(@PathVariable Long id, @ModelAttribute Hakim hakim) {
    hakim.setId(id); // pastikan ID tetap sama
    hakimRepository.save(hakim); // simpan perubahan
    return "redirect:/Hakim/lihat_data_hakim";
}


}
