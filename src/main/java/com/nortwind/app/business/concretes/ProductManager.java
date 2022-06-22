package com.nortwind.app.business.concretes;

import com.nortwind.app.business.abstracts.ProductService;
import com.nortwind.app.core.utilities.results.DataResult;
import com.nortwind.app.core.utilities.results.Result;
import com.nortwind.app.core.utilities.results.SuccessDataResult;
import com.nortwind.app.core.utilities.results.SuccessResult;
import com.nortwind.app.dataAccess.abstracts.ProductDao;
import com.nortwind.app.entities.concretes.Category;
import com.nortwind.app.entities.concretes.Product;
import com.nortwind.app.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAllWithQuery() {
        /**
         * Bu fonksiyon jpa'nın yanında jdbc'nin de nasıl kullanılacağını hatırlatma amacıyla oluşturulmuştur.
         * Bütün datanın getirilmesini sağlar.
         * Yorum satırı bulunana alanlar da deneme amaçlı yapılan sorgulardır ve yine hatırlatma olması için silinmemiştir.
        **/
        try{
            //ResultSet resultSet = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Northwind","postgres","12345").createStatement().executeQuery("select * from categories where category_id = (select category_id from products where product_name = 'Chai' FETCH FIRST 1 ROWS ONLY) ");
            ResultSet resultSet = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Northwind","postgres","12345").createStatement().executeQuery("Select * from products");
            ArrayList<Product> arrayList = new ArrayList<>();
            while(resultSet.next()){
                //resultSet.getString("quantity_per_unit")
                arrayList.add(new Product(resultSet.getInt("product_id"),
                        resultSet.getString("product_name"),
                        resultSet.getDouble("unit_price"),
                        resultSet.getInt("units_in_stock"),
                        resultSet.getString("quantity_per_unit"),
                        new Category()));
            }
            return new SuccessDataResult(arrayList,"Ürünler listelendi.");
            //while (resultSet.next())
            //    System.out.println(resultSet.getString("category_name"));
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(productDao.findAll(),"Ürünler listelendi.");
    }

    @Override
    public Result add(Product product) {
        productDao.save(product);
        return new SuccessResult("Ürün Eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult(productDao.getByProductName(productName),"Data listelendi.");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult(productDao.getByProductNameAndCategory_CategoryId(productName, categoryId),"Data listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult(productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Data listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult(productDao.getByCategoryIn(categories),"Data listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult(productDao.getByProductNameContains(productName),"Data listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult(productDao.getByProductNameStartsWith(productName),"Data listelendi.");
    }

    @Override
    public DataResult<List<Product>> GetByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult(productDao.GetByNameAndCategory(productName, categoryId),"Data listelendi.");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult(productDao.findAll(pageable).getContent(),"Ürünler listelendi");
    }

    @Override
    public DataResult<List<Product>> getAllSorted(int direct) {
        Sort sort;
        if(direct == 1)
            sort = Sort.by(Sort.Direction.DESC,"productId");
        else
            sort = Sort.by(Sort.Direction.ASC,"productId");

        return new SuccessDataResult(productDao.findAll(sort),"Ürünler listelendi.");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult(productDao.getProductWithCategoryDetails(),"Ürünler listelendi.");
    }
}
