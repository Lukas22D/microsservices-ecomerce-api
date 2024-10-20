package app.user_service.controller.dto;

import java.util.List;

import app.ecomerce.model.User;

public record UserReponse(
    Long id,
    String name,
    String email
) {

    public UserReponse(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }

    public static List<UserReponse> fromList(List<User> users) {
        return users.stream().map(UserReponse::new).toList();
    }
}
