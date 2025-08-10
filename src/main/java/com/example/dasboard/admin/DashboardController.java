package com.example.dasboard.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession; // ganti ke javax.servlet.http.HttpSession kalau pakai Spring Boot 2.x

import com.example.dasboard.admin.model.User; // sesuaikan dengan lokasi class User kamu
import com.example.dasboard.admin.repository.HakimRepository;
import com.example.dasboard.admin.repository.HasilSAWRepository;
import com.example.dasboard.admin.repository.KriteriaRepository;
import com.example.dasboard.admin.repository.UserRepository;

@Controller
public class DashboardController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private HakimRepository hakimRepo;

    @Autowired
    private KriteriaRepository kriteriaRepo;

    @Autowired
    private HasilSAWRepository hasilRepo;

   @GetMapping("/dashboard")
public String dashboard(Model model, HttpSession session) {
    String username = (String) session.getAttribute("username");

    if (username == null) {
        return "redirect:/"; // kalau belum login, kembali ke login
    }

    // ambil data user dari database
    User user = userRepo.findById(username).orElse(null);
    model.addAttribute("user", user);

    long totalUsers = userRepo.count();
    long totalHakim = hakimRepo.count();
    long totalKriteria = kriteriaRepo.count();
    long totalSaw = hasilRepo.count();

    model.addAttribute("totalUsers", totalUsers);
    model.addAttribute("totalHakim", totalHakim);
    model.addAttribute("totalKriteria", totalKriteria);
    model.addAttribute("totalSaw", totalSaw);

    return "dashboard";
}

}
