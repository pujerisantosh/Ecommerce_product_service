package dev.santosh.ecommerceproductservice.services;

import dev.santosh.ecommerceproductservice.dtos.FakeStoreProductDTO;
import dev.santosh.ecommerceproductservice.models.Category;
import dev.santosh.ecommerceproductservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.PrivateKey;


@Service("fakeStoreProductService")
public class FakeStoreProductService implements  ProductService {

    private RestTemplate  restTemplate;

    public  FakeStoreProductService(RestTemplate  restTemplate){
        this.restTemplate = restTemplate;

    }



    @Override
    public Product getSingleProduct(long id) {
        FakeStoreProductDTO fakeStoreProductDTResponse = restTemplate.getForObject(
                "https://fakestoreapi.com/products/{id}",
                FakeStoreProductDTO.class,
                id
        );

        return fakeStoreProductDTResponse.toProduct();
    }


}
