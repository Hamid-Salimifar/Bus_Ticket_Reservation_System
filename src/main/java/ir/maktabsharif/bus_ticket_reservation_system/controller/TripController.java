package ir.maktabsharif.bus_ticket_reservation_system.controller;

import ir.maktabsharif.bus_ticket_reservation_system.model.Trip;
import ir.maktabsharif.bus_ticket_reservation_system.service.TripService;
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
public class TripController {
    private final TripService tripService;


    @GetMapping("/search")
    public String searchTicket(@RequestParam String departure,
                               @RequestParam String destination,
                               @RequestParam String date,
                               Model model) {

        List<Trip> trips = tripService.searchTrip(departure, destination, date);
        model.addAttribute("trips", trips);
        return "home";
    }

    @GetMapping("/admin/add-trip")
    public String goToAddTripPage(Model model){
        model.addAttribute("trip",new Trip());
        return "add-trip";
    }

    @PostMapping("/admin/add-trip")
    public String addTrip(@ModelAttribute Trip trip){
        tripService.saveOrUpdate(trip);
        return "redirect:/admin/add-trip?success";
    }
}
