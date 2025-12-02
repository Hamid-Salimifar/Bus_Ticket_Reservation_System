package ir.maktabsharif.bus_ticket_reservation_system.dto;

import ir.maktabsharif.bus_ticket_reservation_system.model.Gender;

import java.time.LocalDate;
import java.time.LocalTime;

public record TicketDto(
        Long ticketId,
        String userName,
        Gender gender,
        String departure,
        String destination,
        LocalDate departureDate,
        LocalTime departureTime,
        Long tripId
) {}
