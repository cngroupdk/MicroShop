package dk.cngroup.microshop.product.domain;

import dk.cngroup.microshop.product.data.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * TODO LVO - add description
 *
 * @author vondracek
 * @since 11.9.2016 19:08
 */
public interface ProductRepository extends MongoRepository<Product, String> {

    public Product findByName(String name);
}
