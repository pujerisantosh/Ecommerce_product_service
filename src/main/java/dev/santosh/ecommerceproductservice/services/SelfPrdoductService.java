package dev.santosh.ecommerceproductservice.services;

import dev.santosh.ecommerceproductservice.models.Product;
import org.springframework.stereotype.Service;

@Service("selfProductService")
public class SelfPrdoductService implements  ProductService{
    @Override
    public Product getSingleProduct(long id) {
        return null;
    }
}
