package net.proselyte.springbootdemo.controller;

import net.proselyte.springbootdemo.model.User;
import net.proselyte.springbootdemo.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserServiceImp userService;
    @Autowired
    public UserController(UserServiceImp userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users/user-list";
    }
    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "users/user-create";
    }
    @PostMapping("/user-create")
    public  String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "users/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
}
