package com.example.pizzaservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_type")
    @NotEmpty
    private String productType;

    @Column(name = "product_name")
    @NotEmpty
    private String productName;

    @Column(name = "pictureUrl")
    private String pictureUrl;

    @Column
    private String description;

    @Column(name = "product_price")
    @NotEmpty
    private Double price;

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_type() {
        return productType;
    }

    public void setProduct_type(String product_type) {
        this.productType = product_type;
    }

    public String getProduct() {
        return productName;
    }

    public void setProduct(String product) {
        this.productName = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
