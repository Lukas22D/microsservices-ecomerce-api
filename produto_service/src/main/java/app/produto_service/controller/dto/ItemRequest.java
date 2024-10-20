package app.produto_service.controller.dto;

import java.math.BigDecimal;

public record ItemRequest(String name, String description, BigDecimal price, Integer stock, Long customerId) {
    
}
