package dev.santosh.productservice.services;


import dev.santosh.productservice.exceptions.ProductNotFoundException;
import dev.santosh.productservice.models.Product;

import dev.santosh.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//UnitTestcases
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {


    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private SelfProductService productService;


    @Test
    void shouldReturnProductWhenIdExists()  {

        Product product = new Product();
        product.setPrice(10000);
        product.setTitle("iPhone");
        product.setDescription("Apple phone");


        when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));


        Product result = productService.getSingleProduct(1L);


        assertNotNull(result);
        assertEquals("iPhone", result.getTitle());
        verify(productRepository).findById(1L);


    }

    @Test
    void shouldThrowExceptionWhenProductNotFound() {

        when(productRepository.findById(99L))
                .thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class,
                () -> productService.getSingleProduct(99L));
    }

}