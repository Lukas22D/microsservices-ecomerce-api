package app.user_service.service.core;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import java.util.List;
import org.springframework.stereotype.Service;

import app.ecomerce.model.User;
import app.user_service.controller.dto.CreateUserRequest;
import app.user_service.controller.dto.UserReponse;
import app.user_service.handler.custom.UserAlreadyExistsException;
import app.user_service.repository.UserRepository;
import app.user_service.service.UserService;;

@Service
@AllArgsConstructor
public class UserServiceCore implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserReponse saveUser(CreateUserRequest userRequest) {
        return (UserReponse) userRepository.findByEmail(userRequest.email()).map(user -> {
            throw new UserAlreadyExistsException("User exist");
        }).orElseGet(() -> {
            User user = new User(userRequest.name(), userRequest.email(), userRequest.password());
            userRepository.save(user);
            return new UserReponse(user);
        });
    }

    @Override
    public UserReponse getUserById(Long id) {
        return userRepository.findById(id).map(UserReponse::new)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public List<UserReponse> getAllUsers() {
        return UserReponse.fromList(userRepository.findAll());
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        userRepository.deleteById(id);
    }

    @Override
    public UserReponse updateUser(Long id, CreateUserRequest user) {
        return userRepository.findById(id).map(u -> {
            u.setName(user.name());
            u.setEmail(user.email());
            u.setPassword(user.password());
            userRepository.save(u);
            return new UserReponse(u);
        }).orElseThrow(() -> new EntityNotFoundException("User not found"));

    }

}
