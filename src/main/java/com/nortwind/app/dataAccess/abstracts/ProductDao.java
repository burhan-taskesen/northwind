package com.nortwind.app.dataAccess.abstracts;

import com.nortwind.app.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
}
