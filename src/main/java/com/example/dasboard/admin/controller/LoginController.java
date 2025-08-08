package com.example.dasboard.admin.controller;

import com.example.dasboard.admin.model.User;
import com.example.dasboard.admin.repository.UserRepository;
import jakarta.servlet.http.HttpSession;  // untuk session
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String loginForm() {
        return "login";  // menampilkan halaman login.html
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username,
                              @RequestParam String password,
                              HttpSession session,
                              Model model) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            // simpan username di session
            session.setAttribute("username", username);
            // redirect ke /dashboard supaya URL berubah
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Username atau password salah");
            return "login";
        }
    }
    @GetMapping("/logout")
public String logout(HttpSession session) {
    session.invalidate(); // hapus semua data di session
    return "redirect:/"; // kembali ke halaman login
}

   
}
