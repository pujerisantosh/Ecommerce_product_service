package dev.santosh.productservice.services;


import dev.santosh.productservice.exceptions.ProductNotFoundException;
import dev.santosh.productservice.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {


    Product getSingleProduct(long id) throws ProductNotFoundException;

    List<Product> getAllProduct();

    Product createProduct(String title,
                          String description,
                          String image,
                          String category,
                          double price);

    Page<Product> getPaginatedProducts(int pageNo, int pageSize);

}

