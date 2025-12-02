package ir.maktabsharif.bus_ticket_reservation_system.controller;

import ir.maktabsharif.bus_ticket_reservation_system.dto.TicketDto;
import ir.maktabsharif.bus_ticket_reservation_system.model.Ticket;
import ir.maktabsharif.bus_ticket_reservation_system.model.TicketStatus;
import ir.maktabsharif.bus_ticket_reservation_system.model.User;
import ir.maktabsharif.bus_ticket_reservation_system.security.CustomUserDetails;
import ir.maktabsharif.bus_ticket_reservation_system.service.TicketService;
import ir.maktabsharif.bus_ticket_reservation_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;
    private final UserService userService;

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable Long id, Model model,
                      @RequestParam(value = "successMessage", required = false) String successMessage) {
        model.addAttribute("tripId", id);
        if (successMessage != null) {
            model.addAttribute("successMessage", successMessage);
        }
        return "buy_ticket";

    }

    @PostMapping("/buy")
    public String buyTicket(@RequestParam Long tripId,
                            @RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam String gender,
                            @AuthenticationPrincipal CustomUserDetails loggedUser,
                            Model model) {
        if (loggedUser == null) {
            return "redirect:/login";
        }

        String username = loggedUser.getUsername();

        User user = userService.findByUsername(username).orElseThrow();
        Ticket ticket = ticketService.buyTicket(tripId, user);

        String chooseGender = gender.equalsIgnoreCase("MALE") ? "Mr" : "Ms";

        String message = String.format("%s %s %s successfully bought a ticket (ticket_id=%d)",
                chooseGender, firstName, lastName, ticket.getId());

        model.addAttribute("successMessage", message);

        return "redirect:/buy/" + tripId + "?successMessage=" + UriUtils.encode(message, StandardCharsets.UTF_8);


    }

    @GetMapping("/ticketsOfUser")
    public String showUserTickets(@AuthenticationPrincipal CustomUserDetails loggedUser,Model model){
        String username = loggedUser.getUsername();

        User user = userService.findByUsername(username).orElseThrow();
        List<Ticket> foundedTickets = ticketService.findByUser(user);

        model.addAttribute("tickets",foundedTickets);

        return "user_tickets";


    }
    @GetMapping("/showDetails/{id}")
    public String showDetailsOfTicket(@PathVariable Long id,Model model){
        Ticket ticket = ticketService.findById(id);
        TicketDto ticketDto = ticketService.entityToDto(ticket);
        model.addAttribute("ticketDto",ticketDto);
        return "ticket-details";
    }


    @PostMapping("/returnTicket/{id}")
    public String returnTicket(@PathVariable Long id,Model model){
        Ticket ticket = ticketService.findById(id);
        ticket.setUser(null);
        ticket.setTicketStatus(TicketStatus.Available);
        ticketService.saveOrUpdate(ticket);
        return "redirect:/ticketsOfUser";

    }
}
