package app.produto_service.service.core;

import java.util.List;

import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

import app.ecomerce.model.Item;
import app.produto_service.controller.dto.ItemRequest;
import app.produto_service.controller.dto.ItemResponse;
import app.produto_service.repository.CustomerRepository;
import app.produto_service.repository.ItemRepository;
import app.produto_service.service.ItemService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class ItemServiceCore implements ItemService {


    private final ItemRepository itemRepository;
    private final CustomerRepository customerRepository;

    @Override
    public  CompletableFuture<Item> saveItem(ItemRequest item) {
        return customerRepository.findById(item.customerId()).map( c -> {
            Item newItem = new Item(item.name(), item.description(), item.price(), item.stock(), c);
            c.addItem(newItem);
            return CompletableFuture.completedFuture(itemRepository.save(newItem));
        }).orElseThrow( () -> new EntityNotFoundException("Customer not found"));
    }

    @Override
    public List<ItemResponse> getAllItemsByCustomerId(Long customerId) {
        return ItemResponse.fromList(itemRepository.findByCustomerId(customerId));
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Item not found"));
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item updateItem(Item item) {
        itemRepository.findById(item.getId()).orElseThrow( () -> new EntityNotFoundException("Item not found"));
        return itemRepository.save(item);
    }

    @Override
    public Item deleteItemById(Long id) {
       return itemRepository.findById(id).map( i ->
       {
           itemRepository.deleteById(id);
           return i;
       }).orElseThrow( () -> new EntityNotFoundException("Item not found"));
    }
    
}
