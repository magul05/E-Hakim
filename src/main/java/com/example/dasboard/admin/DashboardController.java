package com.example.dasboard.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dasboard.admin.repository.HakimRepository;
import com.example.dasboard.admin.repository.HasilSAWRepository;
import com.example.dasboard.admin.repository.KriteriaRepository;
import com.example.dasboard.admin.repository.UserRepository;



@Controller
public class DashboardController {
  @Autowired
private UserRepository userRepo;

@Autowired
private HakimRepository hakimRepo; // Tambahkan repository hakim

@Autowired
private KriteriaRepository kriteriaRepo;

@Autowired
private HasilSAWRepository hasilRepo;



@GetMapping("/dashboard")
public String dashboard(Model model) {
    model.addAttribute("username", "Admin");

     long totalUsers = userRepo.count();
    long totalHakim = hakimRepo.count();
    long totalKriteria = kriteriaRepo.count();
    long totalSaw = hasilRepo.count(); // Hitung data hasil SAW

    model.addAttribute("totalUsers", totalUsers);
    model.addAttribute("totalHakim", totalHakim);
    model.addAttribute("totalKriteria", totalKriteria);
    model.addAttribute("totalSaw", totalSaw);

    return "dashboard";
}


 
}
