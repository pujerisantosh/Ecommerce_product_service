package dev.santosh.productservice.controllers;


import dev.santosh.productservice.dtos.CreateProductRequestDTO;
import dev.santosh.productservice.exceptions.ProductNotFoundException;
import dev.santosh.productservice.models.Product;
import dev.santosh.productservice.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductsControllers {

    private ProductService productService;

    public ProductsControllers(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;

    }

    @GetMapping("/products/{id}")
    Product getSingleProduct(@PathVariable("id") long id) throws ProductNotFoundException {
        return productService.getSingleProduct(id);

    }

    @GetMapping("/products")
    List<Product> getAllProducts() {

        return productService.getAllProduct();
    }


    @GetMapping("/products/paginated")
    Page<Product> getPaginatedProducts(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize) {

        return productService.getPaginatedProducts(pageNo, pageSize);
    }

    @PostMapping("/products")
    public Product createProduct(CreateProductRequestDTO createProductRequestDTO) {
        return productService.createProduct(createProductRequestDTO.getTitle(),
                createProductRequestDTO.getDescription(),
                createProductRequestDTO.getImage(),
                createProductRequestDTO.getCategory(),
                createProductRequestDTO.getPrice());

    }

}
