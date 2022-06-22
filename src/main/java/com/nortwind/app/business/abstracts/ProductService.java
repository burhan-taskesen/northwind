package com.nortwind.app.business.abstracts;

import com.nortwind.app.core.utilities.results.DataResult;
import com.nortwind.app.core.utilities.results.Result;
import com.nortwind.app.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import javax.xml.crypto.Data;
import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAllWithQuery();

    DataResult<List<Product>> getAll();

    DataResult<List<Product>> getAllSorted(int direct);

    DataResult<List<Product>> getAll(int pageNo, int pageSize);

    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);

    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> GetByNameAndCategory(String productName, int categoryId);
}
