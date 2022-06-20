package com.nortwind.app.business.concretes;

import com.nortwind.app.business.abstracts.ProductService;
import com.nortwind.app.core.utilities.results.DataResult;
import com.nortwind.app.core.utilities.results.Result;
import com.nortwind.app.core.utilities.results.SuccessDataResult;
import com.nortwind.app.core.utilities.results.SuccessResult;
import com.nortwind.app.dataAccess.abstracts.ProductDao;
import com.nortwind.app.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(productDao.findAll(),"Ürünler Listelendi.");
    }

    @Override
    public Result add(Product product) {
        productDao.save(product);
        return new SuccessResult("Ürün Eklendi");
    }
}
