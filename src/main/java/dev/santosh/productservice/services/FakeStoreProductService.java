package dev.santosh.productservice.services;


import dev.santosh.productservice.dtos.FakeStoreProductDTO;
import dev.santosh.productservice.models.Category;
import dev.santosh.productservice.models.Product;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;


    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    @Override
    public Product getSingleProduct(long id) {
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponse = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);


        return fakeStoreProductDTOResponse.getBody().toProduct();
    }


    @Override
    public List<Product> getAllProduct() {
        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);

        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS) {
            products.add(fakeStoreProductDTO.toProduct());
        }
        return products;
    }

    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        return null;
    }

    @Override
    public Page<Product> getPaginatedProducts(int pageNo, int pageSize) {
        return null;
    }

}
