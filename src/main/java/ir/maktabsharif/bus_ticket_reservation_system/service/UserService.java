package ir.maktabsharif.bus_ticket_reservation_system.service;

import ir.maktabsharif.bus_ticket_reservation_system.model.User;

import java.util.Optional;

public interface UserService extends BaseService<User> {
    void register(User user);
    Optional<User> findByUsername(String username);
}
