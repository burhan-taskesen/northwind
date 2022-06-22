package com.nortwind.app.api.controllers;

import com.nortwind.app.business.abstracts.ProductService;
import com.nortwind.app.business.concretes.ProductManager;
import com.nortwind.app.core.utilities.results.DataResult;
import com.nortwind.app.core.utilities.results.Result;
import com.nortwind.app.core.utilities.results.SuccessDataResult;
import com.nortwind.app.dataAccess.abstracts.ProductDao;
import com.nortwind.app.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return productService.getAll();
    }

    @GetMapping("/getallpageable")
    public DataResult<List<Product>> getAll(int pageNo,int pageSize){
        return productService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getallsorted")
    public DataResult<List<Product>> getAll(int direct){
        return productService.getAllSorted(direct);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return productService.add(product);
    }

    @GetMapping("/getbyproductname")
    public DataResult<Product> geybyproductname(String productName){
        return new SuccessDataResult(productService.getByProductName(productName));
    }

    @GetMapping("/getallbyquery")
    public DataResult<List<Product>> getallbyquery(){
        return productService.getAllWithQuery();
    }

    @GetMapping("/getbyproductnameandcategoryid")
    public DataResult<Product> getbyproductnameandcategoryid(String productName,int categoryId){
        return productService.getByProductNameAndCategoryId(productName, categoryId);
    }


}
