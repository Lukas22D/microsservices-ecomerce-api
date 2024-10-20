package app.produto_service.controller.dto;

public record Response200(String message, int status, Object data) {

    public Response200(String message, int status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }
}
