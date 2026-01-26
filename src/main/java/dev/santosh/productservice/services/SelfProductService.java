package dev.santosh.productservice.services;


import dev.santosh.productservice.exceptions.ProductNotFoundException;
import dev.santosh.productservice.models.Category;
import dev.santosh.productservice.models.Product;
import dev.santosh.productservice.repository.CategoryRepository;
import dev.santosh.productservice.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;


@Service("selfProductService")
public class SelfProductService implements ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product with  given id does not exist"));
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(
            String title,
            String description,
            String image,
            String category,
            double price) {

        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);

        Category categoryFromDb = categoryRepository.findByTitle(category);

        if (categoryFromDb == null) {
            Category newCategory = new Category();
            newCategory.setTitle(category);
            categoryFromDb = categoryRepository.save(newCategory);
        }

        product.setCategory(categoryFromDb);
        return productRepository.save(product);
    }

    @Override
    public Page<Product> getPaginatedProducts(int pageNo, int pageSize) {
        return productRepository.findAll(
                PageRequest.of(
                        pageNo,
                        pageSize,
                        Sort.by("title").descending()
                                .and(Sort.by("price").ascending())
                )
        );
    }
}
