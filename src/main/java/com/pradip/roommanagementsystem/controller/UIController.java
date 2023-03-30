package com.pradip.roommanagementsystem.controller;

import com.pradip.roommanagementsystem.dto.projection.UserPersonal;
import com.pradip.roommanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UIController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getIndex(){
        return "users";
    }

    @GetMapping("/create-user")
    public String createuserPage(){
        return "user_create";
    }

    @GetMapping("/delete-user")
    public String deleteUserPage(Model model) throws ClassNotFoundException {
        List<UserPersonal> userPersonal = (List<UserPersonal>) userService.getAllUsers("UserPersonal").getData();
        model.addAttribute("users",userPersonal);
        return "user_delete";
    }
}
