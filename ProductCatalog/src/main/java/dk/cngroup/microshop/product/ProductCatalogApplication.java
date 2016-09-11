package dk.cngroup.microshop.product;

import dk.cngroup.microshop.product.data.Product;
import dk.cngroup.microshop.product.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO LVO - add description
 *
 * @author vondracek
 * @since 11.9.2016 16:10
 */
@SpringBootApplication
public class ProductCatalogApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ProductCatalogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of customers
        repository.save(new Product("Prod1"));
        repository.save(new Product("Prod2"));
    }
}
