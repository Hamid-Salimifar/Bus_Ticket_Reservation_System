package ir.maktabsharif.bus_ticket_reservation_system.repository;

import ir.maktabsharif.bus_ticket_reservation_system.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip,Long> {

    List<Trip> findByDepartureLocationAndDestinationLocationAndDepartureDateOrderByDepartureTimeDesc(String departureLocation, String destinationLocation, LocalDate departureDate);

}
