package ir.maktabsharif.bus_ticket_reservation_system.service.impl;

import ir.maktabsharif.bus_ticket_reservation_system.model.User;
import ir.maktabsharif.bus_ticket_reservation_system.repository.UserRepository;
import ir.maktabsharif.bus_ticket_reservation_system.service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
    }
}
