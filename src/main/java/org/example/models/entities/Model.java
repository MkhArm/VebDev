package org.example.models.entities;

import jakarta.persistence.*;
import org.example.models.baseEntities.TimestampedEntity;
import org.example.models.enums.ModelCategory;
import org.example.models.converters.ModelCategoryConverter;

@Entity
@Table(name = "models")

public class Model extends TimestampedEntity {

    private String name;
    private ModelCategory category;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Model(String name, ModelCategory category, String imageUrl, Integer startYear, Integer endYear, Brand brand) {
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand = brand;
    }
    public Model() {
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(ModelCategory category) {
        this.category = category;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }
    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Column(name = "name", length = 255, nullable = false)
    public String getName() {
        return name;
    }
    @Convert(converter = ModelCategoryConverter.class)
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "category", length = 9, nullable = false)
    public ModelCategory getCategory() {
        return category;
    }
    @Column(name = "imageUrl", length = 512, nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }
    @Column(name = "startYear", length = 9, nullable = false)
    public Integer getStartYear() {
        return startYear;
    }
    @Column(name = "endYear", length = 9, nullable = false)
    public Integer getEndYear() {
        return endYear;
    }
    public Brand getBrand() {
        return brand;
    }
}
