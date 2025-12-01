package ir.maktabsharif.bus_ticket_reservation_system.repository;

import ir.maktabsharif.bus_ticket_reservation_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByUsername(String username);
}
