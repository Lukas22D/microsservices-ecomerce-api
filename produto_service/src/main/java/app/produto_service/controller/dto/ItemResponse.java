package app.produto_service.controller.dto;

public record ItemResponse(Long id, String name, String description, String price, Integer stock, Long customerId) {
    
        public ItemResponse(Long id, String name, String description, String price, Integer stock, Long customerId) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
            this.stock = stock;
            this.customerId = customerId;
        }

        
    
}
