package ir.maktabsharif.bus_ticket_reservation_system.service;

import ir.maktabsharif.bus_ticket_reservation_system.dto.TicketDto;
import ir.maktabsharif.bus_ticket_reservation_system.model.Ticket;
import ir.maktabsharif.bus_ticket_reservation_system.model.User;

import java.util.List;

public interface TicketService extends BaseService<Ticket>{
    Ticket buyTicket(Long tripId, User user);
    List<Ticket> findByUser(User user);
    TicketDto entityToDto(Ticket ticket);
}
