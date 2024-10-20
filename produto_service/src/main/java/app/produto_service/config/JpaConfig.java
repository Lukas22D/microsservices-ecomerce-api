package app.produto_service.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "app.produto_service.repository") 
@EntityScan(basePackages = "app.ecomerce.model")
public class JpaConfig {
}
