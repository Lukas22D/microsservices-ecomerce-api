package app.user_service.controller.dto;

public record CreateUserRequest(String name, String email, String password) {
}