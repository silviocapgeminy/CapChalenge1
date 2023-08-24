package com.example.CapChallenge1.controller;
import com.example.CapChallenge1.Model.User;
import com.example.CapChallenge1.Service.UserService;
import com.example.CapChallenge1.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class LoginController {

    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("home")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }


    @GetMapping("register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }


    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model){
        User existing = userService.findByName(user.getName());
        if (existing != null) {
            result.rejectValue("name", null, "Este utilizador já existe.");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "/register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String listRegisteredUsers(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
