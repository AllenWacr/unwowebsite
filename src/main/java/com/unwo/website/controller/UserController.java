package com.unwo.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unwo.website.bean.User;
import com.unwo.website.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/add")
    public String addUser(ModelMap map) {
        map.addAttribute("type", "add");
        return "addUser";
    }

    @PostMapping("/add")
    public String addUserDone(ModelMap map, User user) {
        map.addAttribute("success", userService.addUser(user));
        map.addAttribute("type", "add");
        return "addUser";
    }

    @GetMapping("/update/${flag}/${id}")
    public String updateUser(ModelMap map, @PathVariable String flag, @PathVariable Integer id) {
        map.addAttribute("user", userService.selectUser(User.builder().id(id).build(), "id"));
        map.addAttribute("flag", flag);
        map.addAttribute("type", "update");
        return "updateUser";
    }

    @PostMapping("/update/${flag}/${id}")
    public String updateUserDone(ModelMap map, @PathVariable String flag, @PathVariable Integer id, String update) {
        User updateUser = User.builder().id(id).build();
        int success;
        switch(flag) {
            case "username": updateUser.setUsername(update); break;
            case "password": updateUser.setPassword(update); break;
            default: 
        }
        success = userService.updateUser(updateUser, flag);
        map.addAttribute("user", userService.selectUser(updateUser, "id"));
        map.addAttribute("success", success);
        map.addAttribute("type", "update");
        return "updateUser";
    }

    @GetMapping("/delete/${id}")
    public String deleteUser(ModelMap map, @PathVariable Integer id) {
        map.addAttribute("user", userService.selectUser(User.builder().id(id).build(), "id"));
        map.addAttribute("type", "delete");
        return "deleteUser";
    }
}
