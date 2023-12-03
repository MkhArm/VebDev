package org.example.models.entities;

import jakarta.persistence.*;
import org.example.models.converters.EngineTypeConverter;
import org.example.models.converters.TransmissionTypeConverter;
import org.example.models.baseEntities.TimestampedEntity;
import org.example.models.enums.EngineType;
import org.example.models.enums.TransmissionType;

import java.math.BigDecimal;

@Entity
@Table(name = "offers")

public class Offer extends TimestampedEntity {

    private String description;
    private EngineType engine;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    private TransmissionType transmission;
    private Integer year;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    public Offer(String description, EngineType engine, String imageUrl, Integer mileage, BigDecimal price, TransmissionType transmission, Integer year, Model model, User seller) {
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model = model;
        this.seller = seller;
    }
    public Offer() {

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
    public void setModel(Model model) {
        this.model = model;
    }
    public void setSeller(User seller) {
        this.seller = seller;
    }
    @Column(name = "description", columnDefinition = "text")
    public String getDescription() {
        return description;
    }
    @Convert(converter = EngineTypeConverter.class)
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "engine", length = 9, nullable = false)
    public EngineType getEngine() {
        return engine;
    }
    @Column(name = "imageUrl", length = 512, nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }
    @Column(name = "mileage", length = 9, nullable = false)
    public Integer getMileage() {
        return mileage;
    }
    @Column(name = "price", columnDefinition = "numeric(18,2)", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }
    @Convert(converter = TransmissionTypeConverter.class)
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "transmission", length = 9, nullable = false)
    public TransmissionType getTransmission() {
        return transmission;
    }
    @Column(name = "year", length = 9, nullable = false)
    public Integer getYear() {
        return year;
    }
    public Model getModel() {
        return model;
    }
    public User getSeller() {
        return seller;
    }

}
