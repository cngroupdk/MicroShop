package dk.cngroup.microshop.product.controller;

import dk.cngroup.microshop.product.data.Product;
import dk.cngroup.microshop.product.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author vondracek
 * @since 11.9.2016 19:31
 */
@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/products")
    public List<Product> listProducts() {

        return repository.findAll();
    }

    @GetMapping("/products/{name}")
    public ResponseEntity getProduct(@PathVariable("name") String name) {

        Product byName = repository.findByName(name);
        if(byName == null) {
            return new ResponseEntity("No product with name '" + name + "' found.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(byName, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody Product product) {

        repository.save(product);

        return new ResponseEntity(product, HttpStatus.OK);
    }

    @DeleteMapping("/products/{name}")
    public ResponseEntity deleteProduct(@PathVariable("name") String name) {

        Product byName = repository.findByName(name);

        if (byName == null) {
            return new ResponseEntity("Can't delete product with name '" + name + "'", HttpStatus.NOT_FOUND);
        }

        repository.delete(byName);

        return new ResponseEntity(name, HttpStatus.OK);
    }
}
