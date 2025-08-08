package com.example.dasboard.admin.controller;

import com.example.dasboard.admin.model.Penilaian;
import com.example.dasboard.admin.model.Hakim;
import com.example.dasboard.admin.repository.HakimRepository;
import com.example.dasboard.admin.repository.PenilaianRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PenilaianController {

    @Autowired
    private HakimRepository hakimRepository;

    @Autowired
    private PenilaianRepository penilaianRepository;

    @GetMapping("/Penilaian/tambah_penilaian")
    public String showForm(Model model) {
        model.addAttribute("penilaian", new Penilaian());

        // Kirim daftar hakim ke view
        List<Hakim> hakimList = hakimRepository.findAll();
        model.addAttribute("hakimList", hakimList);

        return "Penilaian/tambah_penilaian";
    }

    @PostMapping("/Penilaian/simpan")
    public String simpanPenilaian(@ModelAttribute Penilaian penilaian) {
        penilaianRepository.save(penilaian);
        return "redirect:/Penilaian/tambah_penilaian";
    }
    @GetMapping("/Penilaian/lihat_penilaian")
    public String lihatPenilaian(Model model) {
    List<Penilaian> penilaianList = penilaianRepository.findAll();
    model.addAttribute("penilaianList", penilaianList);
    return "Penilaian/lihat_penilaian";
}

}
