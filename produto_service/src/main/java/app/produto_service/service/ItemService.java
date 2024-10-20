package app.produto_service.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import app.ecomerce.model.Item;
import app.produto_service.controller.dto.ItemRequest;
import app.produto_service.controller.dto.ItemResponse;

public interface ItemService {
    
    public CompletableFuture<Item> saveItem(ItemRequest item);

    public List<Item> getAllItems();

    public List<ItemResponse> getAllItemsByCustomerId(Long customerId);

    public Item updateItem(Item item);

    public Item deleteItemById(Long id);

    public Item getItemById(Long id);
    
}
