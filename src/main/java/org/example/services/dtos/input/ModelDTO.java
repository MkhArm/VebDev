package org.example.services.dtos.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.models.enums.ModelCategory;
import org.example.util.customValidators.annotations.ModelConstraint;

import java.util.UUID;
@ModelConstraint
public class ModelDTO {
    private String id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 50, message = "Name length must be between 3 and 50")
    private String name;

    @NotNull(message = "Category cannot be null")
    private ModelCategory category;

    @NotBlank(message = "Image URL cannot be blank")
    private String imageUrl;

    @NotNull(message = "Start year cannot be null")
    private Integer startYear;

    @NotNull(message = "End year cannot be null")
    private Integer endYear;

    @NotNull(message = "Brand cannot be null")
    private String brand_id;

    public ModelDTO(String name, ModelCategory category, String imageUrl, Integer startYear, Integer endYear, String brand_id) {
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand_id = brand_id;
    }
    public ModelDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModelCategory getCategory() {
        return category;
    }

    public void setCategory(ModelCategory category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }
}

