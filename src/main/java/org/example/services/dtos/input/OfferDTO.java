package org.example.services.dtos.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.example.models.enums.EngineType;
import org.example.models.enums.TransmissionType;
import org.example.util.customValidators.annotations.OfferConstraint;

import java.math.BigDecimal;
import java.util.UUID;
@OfferConstraint
public class OfferDTO {
    private String id;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotNull(message = "Engine type cannot be null")
    private EngineType engine;

    @NotBlank(message = "Image URL cannot be blank")
    private String imageUrl;

    @Positive(message = "Mileage must be a positive value")
    private Integer mileage;

    @Positive(message = "Price must be a positive value")
    private BigDecimal price;

    @NotNull(message = "Transmission type cannot be null")
    private TransmissionType transmission;

    @NotNull(message = "Year cannot be null")
    private Integer year;

    @NotNull(message = "Model cannot be null")
    private String model_id;

    @NotNull(message = "Seller cannot be null")
    private String seller_id;

    public OfferDTO(String description, EngineType engine, String imageUrl, Integer mileage, BigDecimal price, TransmissionType transmission, Integer year, String model_id, String seller_id) {
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model_id = model_id;
        this.seller_id = seller_id;
    }

    public OfferDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getModel_id() {
        return model_id;
    }

    public void setModel_id(String model_id) {
        this.model_id = model_id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    @Override
    public String toString() {
        return "OfferDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", year=" + year +
                ", model_id='" + model_id + '\'' +
                ", seller_id='" + seller_id + '\'' +
                '}';
    }
}

