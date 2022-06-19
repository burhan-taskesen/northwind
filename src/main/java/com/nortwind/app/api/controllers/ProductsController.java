package com.nortwind.app.api.controllers;

import com.nortwind.app.business.abstracts.ProductService;
import com.nortwind.app.business.concretes.ProductManager;
import com.nortwind.app.dataAccess.abstracts.ProductDao;
import com.nortwind.app.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private List<Product> getAll(){
        return productService.getAll();
    }
}
