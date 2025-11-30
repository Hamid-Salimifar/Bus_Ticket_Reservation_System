package ir.maktabsharif.bus_ticket_reservation_system.model;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String Email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;



}
