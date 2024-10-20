package app.produto_service.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import app.ecomerce.model.Item;
import app.produto_service.controller.dto.ItemRequest;

public interface ItemService {
    
    public CompletableFuture<Item> saveItem(ItemRequest item);

    public List<Item> getAllItems();

    public Item updateItem(Item item);

    public Item deleteItemById(Long id);

    public Item getItemById(Long id);
    
}
