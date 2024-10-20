package app.ecomerce.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "social_name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cart = new Cart(this);
    }
    
}