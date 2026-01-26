package dev.santosh.productservice.controllers;

import org.springframework.boot.test.web.client.TestRestTemplate;
import dev.santosh.productservice.dtos.ErrorDTO;
import dev.santosh.productservice.models.Product;
import dev.santosh.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ProductsControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldReturnProductById() {
        Product product = new Product();
        product.setTitle("MacBook");
        product.setPrice(150000);
        product.setDescription("Apple laptop");

        Product saved = productRepository.save(product);

        String url = "http://localhost:" + port + "/products/" + saved.getId();

        ResponseEntity<Product> response =
                restTemplate.getForEntity(url, Product.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("MacBook", response.getBody().getTitle());
    }

    @Test
    void shouldReturn404_whenProductNotFound() {
        String url = "http://localhost:" + port + "/products/99999";

        ResponseEntity<ErrorDTO> response =
                restTemplate.getForEntity(url, ErrorDTO.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(
                "Product with  given id does not exist",
                response.getBody().getMessage()
        );
    }


    @Test
    void shouldCreateProductSuccessfully() {

        String url = "http://localhost:" + port + "/products";

        String requestBody = """
            {
              "title": "iPhone 15",
              "description": "Latest Apple phone",
              "category": "Electronics",
              "image": "iphone.png",
              "price": 120000
            }
            """;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Product> response =
                restTemplate.postForEntity(url, entity, Product.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("iPhone 15", response.getBody().getTitle());
    }

    @Test
    void shouldReturn400_whenInvalidProductRequest() {

        String url = "http://localhost:" + port + "/products";

        String requestBody = """
            {
              "description": "No title",
              "category": "Electronics",
              "price": -10
            }
            """;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<ErrorDTO> response =
                restTemplate.postForEntity(url, request, ErrorDTO.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

}