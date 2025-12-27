package dev.santosh.productservice.dtos;

import dev.santosh.productservice.models.Category;
import dev.santosh.productservice.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductDTO {
    private long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;


    public Product toProduct() {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);

        Category cat = new Category();
        cat.setTitle(category);

        product.setCategory(cat);

        return product;
    }


}
