package dk.cngroup.microshop.product.data;

import org.springframework.data.annotation.Id;

/**
 * TODO LVO - add description
 *
 * @author vondracek
 * @since 11.9.2016 19:06
 */
public class Product {

    @Id
    private String id;

    private String name;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
