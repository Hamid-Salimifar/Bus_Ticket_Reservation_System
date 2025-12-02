package ir.maktabsharif.bus_ticket_reservation_system.controller;

import ir.maktabsharif.bus_ticket_reservation_system.model.Trip;
import ir.maktabsharif.bus_ticket_reservation_system.model.User;
import ir.maktabsharif.bus_ticket_reservation_system.service.TripService;
import ir.maktabsharif.bus_ticket_reservation_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TripService tripService;

    @GetMapping("/home")
    public String getToHomeAfterLogin(Model model) {
        model.addAttribute("message", "Welcome");
        return "home";
    }


    @GetMapping("/register")
    public String getToRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.register(user);
        return "redirect:/login?registered";
    }





}
