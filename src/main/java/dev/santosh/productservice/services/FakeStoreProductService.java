package dev.santosh.productservice.services;


import dev.santosh.productservice.dtos.FakeStoreProductDTO;
import dev.santosh.productservice.models.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private final RestTemplate restTemplate;
    private final RedisTemplate<String, Object> redisTemplate;

    public FakeStoreProductService(RestTemplate restTemplate,
                                   RedisTemplate<String, Object> redisTemplate) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Product getSingleProduct(long id) {

        String key = "product_" + id;

        Product cachedProduct =
                (Product) redisTemplate.opsForValue().get(key);

        if (cachedProduct != null) {
            return cachedProduct;
        }

        ResponseEntity<FakeStoreProductDTO> response =
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDTO.class
                );

        if (response.getBody() == null) {
            throw new RuntimeException("Product not found");
        }

        Product product = response.getBody().toProduct();
        redisTemplate.opsForValue().set(key, product);
        return product;
    }

    @Override
    public List<Product> getAllProduct() {

        FakeStoreProductDTO[] dtos =
                restTemplate.getForObject(
                        "https://fakestoreapi.com/products",
                        FakeStoreProductDTO[].class
                );

        List<Product> products = new ArrayList<>();
        if (dtos != null) {
            for (FakeStoreProductDTO dto : dtos) {
                products.add(dto.toProduct());
            }
        }
        return products;
    }

    @Override
    public Product createProduct(String title, String description,
                                 String image, String category, double price) {
        return null;
    }

    @Override
    public Page<Product> getPaginatedProducts(int pageNo, int pageSize) {
        return null;
    }

}
