package ir.maktabsharif.bus_ticket_reservation_system.service.impl;

import ir.maktabsharif.bus_ticket_reservation_system.model.Ticket;
import ir.maktabsharif.bus_ticket_reservation_system.repository.TicketRepository;
import ir.maktabsharif.bus_ticket_reservation_system.service.TicketService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl extends BaseServiceImpl<Ticket> implements TicketService {

    public TicketServiceImpl(TicketRepository ticketRepository) {
        super(ticketRepository);
    }
}
