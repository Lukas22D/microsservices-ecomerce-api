package app.produto_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.produto_service.controller.dto.ItemRequest;
import app.produto_service.service.ItemService;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public CompletableFuture<ResponseEntity<String>> createItem(@RequestBody ItemRequest item) {
         CompletableFuture.supplyAsync(() -> itemService.saveItem(item));
        return CompletableFuture.completedFuture(ResponseEntity.ok().body("Item created"));
    }
    
}
