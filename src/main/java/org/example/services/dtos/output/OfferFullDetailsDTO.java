package org.example.services.dtos.output;

import org.example.models.enums.EngineType;
import org.example.models.enums.TransmissionType;
import org.example.services.dtos.baseEntities.BaseEntityDTO;

import java.math.BigDecimal;

public class OfferFullDetailsDTO extends BaseEntityDTO {

    private BigDecimal price;
    private Integer year;
    private String brandName;
    private String modelName;
    private String imageUrl;
    private EngineType engine;
    private TransmissionType transmission;
    private Integer mileage;
    private String seller_id;
    private String seller_username;
    private String description;

    public OfferFullDetailsDTO(BigDecimal price, Integer year, String brandName, String modelName, String imageUrl, EngineType engine, TransmissionType transmission, Integer mileage, String seller_id, String seller_username, String description) {
        this.price = price;
        this.year = year;
        this.brandName = brandName;
        this.modelName = modelName;
        this.imageUrl = imageUrl;
        this.engine = engine;
        this.transmission = transmission;
        this.mileage = mileage;
        this.seller_id = seller_id;
        this.seller_username = seller_username;
        this.description = description;
    }

    public OfferFullDetailsDTO() {
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setEngine(EngineType engine) {
        this.engine = engine;
    }
    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }
    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setSeller_username(String seller_username) {
        this.seller_username = seller_username;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public Integer getYear() {
        return year;
    }
    public String getBrandName() {
        return brandName;
    }
    public String getModelName() {
        return modelName;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public EngineType getEngine() {
        return engine;
    }
    public TransmissionType getTransmission() {
        return transmission;
    }
    public Integer getMileage() {
        return mileage;
    }
    public String getSeller_id() {
        return seller_id;
    }
    public String getDescription() {
        return description;
    }
    public String getSeller_username() {
        return seller_username;
    }

    @Override
    public String toString() {
        return "OfferFullDetailsDTO{" +
                "price=" + price +
                ", year=" + year +
                ", brandName='" + brandName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", engine=" + engine +
                ", transmission=" + transmission +
                ", mileage=" + mileage +
                ", seller_id='" + seller_id + '\'' +
                ", seller_username='" + seller_username + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
