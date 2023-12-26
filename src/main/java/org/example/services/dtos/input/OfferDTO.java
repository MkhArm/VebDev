package org.example.services.dtos.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.example.models.enums.EngineType;
import org.example.models.enums.TransmissionType;
import org.example.util.customValidators.annotations.OfferConstraint;
import java.math.BigDecimal;

@OfferConstraint
public class OfferDTO {
    private String id;
    private String description;
    private EngineType engine;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    private TransmissionType transmission;
    private Integer year;
    private String model_id;
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

    public OfferDTO(String description, EngineType engine, String imageUrl, Integer mileage, BigDecimal price, TransmissionType transmission, Integer year, String model_id) {
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model_id = model_id;
    }

    public OfferDTO() {
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setEngine(EngineType engine) {
        this.engine = engine;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public void setModel_id(String model_id) {
        this.model_id = model_id;
    }
    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }
    public String getId() {
        return id;
    }
    @NotBlank(message = "Description cannot be blank")
    public String getDescription() {
        return description;
    }
    @NotNull(message = "Engine type cannot be null")
    public EngineType getEngine() {
        return engine;
    }
    @NotBlank(message = "Image URL cannot be blank")
    public String getImageUrl() {
        return imageUrl;
    }
    @Positive(message = "Mileage must be a positive value")
    public Integer getMileage() {
        return mileage;
    }
    @Positive(message = "Price must be a positive value")
    public BigDecimal getPrice() {
        return price;
    }
    @NotNull(message = "Transmission type cannot be null")
    public TransmissionType getTransmission() {
        return transmission;
    }
    @NotNull(message = "Year cannot be null")
    public Integer getYear() {
        return year;
    }
    @NotNull(message = "Model cannot be null")
    public String getModel_id() {
        return model_id;
    }
    public String getSeller_id() {
        return seller_id;
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

