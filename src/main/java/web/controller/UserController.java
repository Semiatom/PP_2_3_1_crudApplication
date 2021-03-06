package web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import web.Service.UserService;
import web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller

public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {

        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "users_list";
    }

    @GetMapping("/user-create")
    public String createUserForm(Model model) {
        model.addAttribute("user",new User());
        return "user_create";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "user_create";
        }
        userService.addUser(user);
        return "redirect: /";
    }

    @GetMapping("/user-edit/{id}")
    public String editUserForm(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "user_edit";
    }

    @PostMapping("/user-update/{id}")
    public String editUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "user_edit";
        }
        userService.editUser(user);
        return "redirect: /";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id")int id){
        userService.removeUserById(id);
        return "redirect: /";
    }





}