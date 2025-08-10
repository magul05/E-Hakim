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


@GetMapping("/User/edit_user/{username}")
    public String showEditForm(@PathVariable("username") String username, Model model) {
        User user = userRepo.findById(username)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user username:" + username));
        model.addAttribute("user", user);
        return "User/edit_user";  // tanpa slash
    }

    @PostMapping("/user/update")
    public String updateUser(@ModelAttribute User user) {
        userRepo.save(user);
        return "redirect:/User/edit_user/" + user.getUsername();
    }


}
