package dev.santosh.productservice.controllers;


import dev.santosh.productservice.dtos.CreateProductRequestDTO;
import dev.santosh.productservice.exceptions.ProductNotFoundException;
import dev.santosh.productservice.models.Product;
import dev.santosh.productservice.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Validated
public class ProductsControllers {

    private final ProductService productService;

    public ProductsControllers(
            @Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    // GET /products/{id}
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable long id)
            throws ProductNotFoundException {
        return productService.getSingleProduct(id);
    }

    // GET /products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    // GET /products/paginated?pageNo=0&pageSize=10
    @GetMapping("/paginated")
    public Page<Product> getPaginatedProducts(
            @RequestParam int pageNo,
            @RequestParam int pageSize) {
        return productService.getPaginatedProducts(pageNo, pageSize);
    }

    // POST /products
    @PostMapping
    public Product createProduct(
           @Valid @RequestBody CreateProductRequestDTO requestDTO) {

        return productService.createProduct(
                requestDTO.getTitle(),
                requestDTO.getDescription(),
                requestDTO.getImage(),
                requestDTO.getCategory(),
                requestDTO.getPrice()
        );
    }

}
