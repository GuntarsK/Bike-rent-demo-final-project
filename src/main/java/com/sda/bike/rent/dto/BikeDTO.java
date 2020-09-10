package com.sda.bike.rent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class BikeDTO extends DtoHolder {

    @JsonProperty("bike_pk")
    private Long bikePk;

    @NotBlank(message = "Please provide bike manufacturer")
    @JsonProperty("manufacturer")
    private String manufacturer;

    @NotBlank(message = "Please provide bike model")
    @JsonProperty("bike_model")
    private String bikeModel;

    @NotBlank(message = "Please provide bike category")
    @JsonProperty("category")
    private String category;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("pcs_in_stock")
    private Integer pcsInStock;

    @JsonProperty("status")
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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
