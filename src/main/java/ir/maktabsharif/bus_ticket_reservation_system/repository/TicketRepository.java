package ir.maktabsharif.bus_ticket_reservation_system.repository;

import ir.maktabsharif.bus_ticket_reservation_system.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
