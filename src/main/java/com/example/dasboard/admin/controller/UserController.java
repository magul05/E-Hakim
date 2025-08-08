package com.example.dasboard.admin.controller;

import com.example.dasboard.admin.model.User;
import com.example.dasboard.admin.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/User/tambah_user")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "/User/tambah_user";
    }
   @PostMapping("/user/simpan")
public String simpanUser(@ModelAttribute User user) {
    userRepo.save(user);
    return "/User/tambah_user";
}

}
