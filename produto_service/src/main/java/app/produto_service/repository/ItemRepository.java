package app.produto_service.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.ecomerce.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByCustomerId(Long customerId);
    
}
