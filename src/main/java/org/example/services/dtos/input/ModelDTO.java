package org.example.services.dtos.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.models.enums.ModelCategory;
import org.example.util.customValidators.annotations.ModelConstraint;

@ModelConstraint
public class ModelDTO {
    private String id;
    private String name;
    private ModelCategory category;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
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

    public void setId(String id) {
        this.id = id;
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
    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }
    public String getId() {
        return id;
    }
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 50, message = "Name length must be between 3 and 50")
    public String getName() {
        return name;
    }
    @NotNull(message = "Category cannot be null")
    public ModelCategory getCategory() {
        return category;
    }
    @NotBlank(message = "Image URL cannot be blank")
    public String getImageUrl() {
        return imageUrl;
    }
    @NotNull(message = "Start year cannot be null")
    public Integer getStartYear() {
        return startYear;
    }
    @NotNull(message = "End year cannot be null")
    public Integer getEndYear() {
        return endYear;
    }
    @NotNull(message = "Brand cannot be null")
    public String getBrand_id() {
        return brand_id;
    }
}

