package com.geekbrains.spring.mvc.repositories;

import com.geekbrains.spring.mvc.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
        products.add(new Product(1, "Картошка", 26));
        products.add(new Product(2, "Лук", 54));
        products.add(new Product(3, "Морковь", 18));
        products.add(new Product(4, "Помидоры", 190));
        products.add(new Product(5, "Свекла", 56));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public void save(Product product){
        products.add(product);
    }

    public void deleteOnId(Integer id){
        products.removeIf(b -> b.getId().equals(id));
    }

    public void deleteAll(){
        products.removeAll(getAllProducts());
    }
}
