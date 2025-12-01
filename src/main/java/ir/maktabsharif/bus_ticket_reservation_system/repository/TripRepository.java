package ir.maktabsharif.bus_ticket_reservation_system.repository;

import ir.maktabsharif.bus_ticket_reservation_system.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip,Long> {
}
