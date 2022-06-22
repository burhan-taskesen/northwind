package com.nortwind.app.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","category"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    //@Column(name = "category_id")
    //private int categoryId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;

    /** Products tablosu ile categories tablosunu category_id ile bağladık
     *  Bu sayede "getByProductNameAndCategory" gibi fonksiyonlarda verilen
     *  değerler Category nesnesinin category_id öğesiyle bağdaştırılır.
    **/
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    /*
    public Product(int id, String productName, double unitPrice, int unitsInStock, String quantityPerUnit) {
        this.id = id;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.quantityPerUnit = quantityPerUnit;
    }*/
}
