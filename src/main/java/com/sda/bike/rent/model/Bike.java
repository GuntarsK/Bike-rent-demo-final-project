package com.sda.bike.rent.model;

import com.sda.bike.rent.model.userTypeEnum.BikeCategory;

import javax.persistence.*;

@Entity
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bike_pk")
    private Long bikePk;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "bike_model")
    private String bikeModel;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private BikeCategory category;

    @Column(name = "price")
    private Double price;

    @Column(name = "pcs_in_stock")
    private Integer pcsInStock;

    @Column(name = "status")
    private String status;

    public Long getBikePk() {
        return bikePk;
    }

    public void setBikePk(Long bikePk) {
        this.bikePk = bikePk;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    public BikeCategory getCategory() {
        return category;
    }

    public void setCategory(BikeCategory category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPcsInStock() {
        return pcsInStock;
    }

    public void setPcsInStock(Integer pcsInStock) {
        this.pcsInStock = pcsInStock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
