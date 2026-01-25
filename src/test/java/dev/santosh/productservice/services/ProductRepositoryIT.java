package dev.santosh.productservice.services;


import dev.santosh.productservice.models.Product;
import dev.santosh.productservice.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("Test")
@Transactional
public class ProductRepositoryIT {


    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldSaveAndFetchProduct() {

        Product product = new Product();
        product.setTitle("MacBook");
        product.setPrice(150000);
        product.setDescription("Apple laptop");

        Product saved = productRepository.save(product);

        Optional<Product> fetched =
                productRepository.findById(saved.getId());

        assertTrue(fetched.isPresent());
        assertEquals("MacBook", fetched.get().getTitle());
    }

    @Test
    void shouldReturnEmptyWhenProductNotFound() {

        Optional<Product> result =
                productRepository.findById(999L);

        assertTrue(result.isEmpty());
    }
}
