package ir.maktabsharif.bus_ticket_reservation_system.service.impl;

import ir.maktabsharif.bus_ticket_reservation_system.model.Trip;
import ir.maktabsharif.bus_ticket_reservation_system.repository.TripRepository;
import ir.maktabsharif.bus_ticket_reservation_system.service.TripService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl extends BaseServiceImpl<Trip> implements TripService {

    public TripServiceImpl(TripRepository tripRepository) {
        super(tripRepository);
    }
}
