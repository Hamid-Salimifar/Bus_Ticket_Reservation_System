package ir.maktabsharif.bus_ticket_reservation_system.service.impl;

import ir.maktabsharif.bus_ticket_reservation_system.model.Ticket;
import ir.maktabsharif.bus_ticket_reservation_system.model.TicketStatus;
import ir.maktabsharif.bus_ticket_reservation_system.model.Trip;
import ir.maktabsharif.bus_ticket_reservation_system.repository.TicketRepository;
import ir.maktabsharif.bus_ticket_reservation_system.repository.TripRepository;
import ir.maktabsharif.bus_ticket_reservation_system.service.TripService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TripServiceImpl extends BaseServiceImpl<Trip> implements TripService {
    private final TripRepository tripRepository;
    private final TicketRepository ticketRepository;
    public TripServiceImpl(TripRepository tripRepository,TicketRepository ticketRepository) {
        super(tripRepository);
        this.tripRepository=tripRepository;
        this.ticketRepository=ticketRepository;
    }

    @Override
    public List<Trip> searchTrip(String destination, String departure, String date) {
        LocalDate departureDate=LocalDate.parse(date);
        return tripRepository.findByDepartureLocationAndDestinationLocationAndDepartureDateOrderByDepartureTimeDesc(
                destination,
                departure,
                departureDate);
    }

    @Override
    public Trip saveOrUpdate(Trip trip) {
        Trip savedTrip = tripRepository.save(trip);

        for (int i=0 ;i<savedTrip.getNumberOfTickets();i++){
            Ticket ticket=Ticket.builder()
                    .trip(savedTrip)
                    .ticketStatus(TicketStatus.Available)
                    .build();
            ticketRepository.save(ticket);
        }
        return savedTrip;
    }
}
