package ir.maktabsharif.bus_ticket_reservation_system.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String destinationLocation;
    private String departureLocation;

    @Enumerated(EnumType.STRING)
    private BusType busType;


    private String busDriver;

    private LocalDate departureDate;
    private LocalTime departureTime;

    private Integer numberOfTickets;

    @OneToMany(mappedBy = "trip")
    private Set<Ticket> tickets=new HashSet<>();


}
