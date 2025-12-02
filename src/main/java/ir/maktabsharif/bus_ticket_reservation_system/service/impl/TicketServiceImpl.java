package ir.maktabsharif.bus_ticket_reservation_system.service.impl;

import ir.maktabsharif.bus_ticket_reservation_system.dto.TicketDto;
import ir.maktabsharif.bus_ticket_reservation_system.model.Ticket;
import ir.maktabsharif.bus_ticket_reservation_system.model.TicketStatus;
import ir.maktabsharif.bus_ticket_reservation_system.model.Trip;
import ir.maktabsharif.bus_ticket_reservation_system.model.User;
import ir.maktabsharif.bus_ticket_reservation_system.repository.TicketRepository;
import ir.maktabsharif.bus_ticket_reservation_system.service.TicketService;
import ir.maktabsharif.bus_ticket_reservation_system.service.TripService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketServiceImpl extends BaseServiceImpl<Ticket> implements TicketService {
    private final TicketRepository ticketRepository;
    private final TripService tripService;

    public TicketServiceImpl(TicketRepository ticketRepository, TripService tripService) {
        super(ticketRepository);
        this.ticketRepository = ticketRepository;
        this.tripService = tripService;
    }

    @Override
    public List<Ticket> findByUser(User user) {
        return ticketRepository.findByUser(user);
    }

    @Override
    @Transactional
    public Ticket buyTicket(Long tripId, User user) {
        Trip trip = tripService.findById(tripId);
        Ticket ticket1 = trip.getTickets().stream()
                .filter(ticket -> ticket.getTicketStatus().equals(TicketStatus.Available))
                .findFirst()
                .orElseThrow();
        ticket1.setTicketStatus(TicketStatus.Purchased);
        ticket1.setUser(user);
        Ticket savedTicket = ticketRepository.save(ticket1);
        return savedTicket;
    }
    @Override
    public TicketDto entityToDto(Ticket ticket){
        return new TicketDto(
                ticket.getId(),
                ticket.getUser().getUsername(),
                ticket.getUser().getGender(),
                ticket.getTrip().getDepartureLocation(),
                ticket.getTrip().getDestinationLocation(),
                ticket.getTrip().getDepartureDate(),
                ticket.getTrip().getDepartureTime(),
                ticket.getTrip().getId()
        );
    }
}
