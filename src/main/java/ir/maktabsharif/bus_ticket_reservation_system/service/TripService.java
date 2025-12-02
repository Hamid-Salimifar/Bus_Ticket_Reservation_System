package ir.maktabsharif.bus_ticket_reservation_system.service;

import ir.maktabsharif.bus_ticket_reservation_system.model.Trip;

import java.util.List;

public interface TripService extends BaseService<Trip>{
    List<Trip> searchTrip(String destination,String departure, String date);
}
