package app.ecomerce.model;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@Entity(name = "produto")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Item(String name, String description, BigDecimal price, Integer stock, Customer customer) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.customer = customer;
    }


}
