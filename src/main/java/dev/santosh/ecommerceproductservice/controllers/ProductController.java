package dev.santosh.ecommerceproductservice.controllers;

import dev.santosh.ecommerceproductservice.models.Product;
import dev.santosh.ecommerceproductservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") long id) {
        return productService.getSingleProduct(id);
    }
    //create product

}
