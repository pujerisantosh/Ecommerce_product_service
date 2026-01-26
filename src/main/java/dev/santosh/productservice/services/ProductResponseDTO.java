package dev.santosh.productservice.services;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ProductResponseDTO {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
}
