package com.nortwind.app.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private int categoryId;
    private String productName;
    private double unitPrice;
    private int unitsInStock;
    private String quantityPerUnit;

}
