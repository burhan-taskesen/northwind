package com.nortwind.app.business.abstracts;

import com.nortwind.app.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
}
