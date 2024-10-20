package app.user_service.service;

import java.util.List;


import app.user_service.controller.dto.CreateUserRequest;
import app.user_service.controller.dto.UserReponse;

public interface UserService {
    public UserReponse saveUser(CreateUserRequest userRequest);

    public UserReponse getUserById(Long id);

    public List<UserReponse> getAllUsers();

    public void deleteUserById(Long id);

    public UserReponse updateUser(Long id, CreateUserRequest user);

}
