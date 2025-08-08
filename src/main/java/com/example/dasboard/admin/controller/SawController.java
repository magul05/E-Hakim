package com.example.dasboard.admin.controller;

import com.example.dasboard.admin.model.HasilSAW;
import com.example.dasboard.admin.service.SawService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SawController {

    @Autowired
    private SawService sawService;

    // Saat halaman dibuka → hitung SAW → tampilkan hasil
    @GetMapping("/Saw/hasilsaw")
    public String tampilkanHasil(Model model) {
        sawService.hitungDanSimpanKeDatabase(); // Hitung & simpan dulu
        List<HasilSAW> hasil = sawService.getAllHasilSAW(); // Ambil hasilnya
        model.addAttribute("hasil", hasil);
        return "/Saw/hasilsaw"; // Tampilkan ke halaman peringkat.html
    }
   @PostMapping("/simpan")
public String simpanHasilSAW() {
    sawService.hitungDanSimpanKeDatabase();
    return "redirect:/Saw/hasilsaw"; // arahkan ke halaman hasil
}

}
