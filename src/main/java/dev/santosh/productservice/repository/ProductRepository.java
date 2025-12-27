package dev.santosh.productservice.repository;

import dev.santosh.productservice.models.Category;
import dev.santosh.productservice.models.Product;
import dev.santosh.productservice.projections.ProductWithIdAndPriceProjection;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Derived queries
    List<Product> findByCategory(Category category);

    List<Product> findAllByCategory_Title(String title);

    List<Product> findAllByCategory_Id(Long id);

    // JPQL Projection
    @Query(
            "select p.id as id, p.price as price " +
                    "from Product p " +
                    "where p.category.title = :categoryName"
    )
    List<ProductWithIdAndPriceProjection>
    getProductTitleAndPriceGivenCategoryName(
            @Param("categoryName") String categoryName
    );

    // Native SQL Projection
    @Query(
            value = "SELECT p.id, p.price FROM product p WHERE p.title = :title",
            nativeQuery = true
    )
    List<ProductWithIdAndPriceProjection>
    getProductTitleAndPriceGivenTitle(
            @Param("title") String title
    );


}

