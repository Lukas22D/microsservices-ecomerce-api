package app.produto_service.controller.dto;

import java.util.List;

import app.ecomerce.model.Item;

public record ItemResponse(Long id, String name, String description, String price, Integer stock, Long customerId) {
    
        public ItemResponse(Long id, String name, String description, String price, Integer stock, Long customerId) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
            this.stock = stock;
            this.customerId = customerId;
        }

        public static List<ItemResponse> fromList(List<Item> items) {
        return items.stream().map(
            item -> new ItemResponse(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice().toString(),
                item.getStock(),
                item.getCustomer().getId()
            )
        ).toList();
    }

    
}
