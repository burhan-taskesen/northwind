package com.nortwind.app.dataAccess.abstracts;

import com.nortwind.app.core.utilities.results.Result;
import com.nortwind.app.entities.concretes.Product;
import com.nortwind.app.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategoryIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> GetByNameAndCategory(String productName, int categoryId);

    @Query("Select new com.nortwind.app.entities.dtos.ProductWithCategoryDto(p.productId,p.productName,c.categoryName) From Category c inner join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();

}
