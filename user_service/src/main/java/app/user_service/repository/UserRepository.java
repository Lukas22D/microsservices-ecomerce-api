package app.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import app.ecomerce.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
}
