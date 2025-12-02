package ir.maktabsharif.bus_ticket_reservation_system.initialization;

import ir.maktabsharif.bus_ticket_reservation_system.model.Role;
import ir.maktabsharif.bus_ticket_reservation_system.model.User;
import ir.maktabsharif.bus_ticket_reservation_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@RequiredArgsConstructor
public class AdminInitializer implements CommandLineRunner {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userService.findByUsername("admin").isEmpty()) {
            User admin = User.builder()
                    .username("admin")
                    .role(Role.ADMIN)
                    .password(passwordEncoder.encode("admin"))
                    .build();
            userService.saveOrUpdate(admin);
        }
    }
}
