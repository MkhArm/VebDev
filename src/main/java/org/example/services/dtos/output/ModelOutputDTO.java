package org.example.services.dtos.output;


import org.example.models.enums.ModelCategory;
import org.example.services.dtos.baseEntities.BaseEntityDTO;

public class ModelOutputDTO extends BaseEntityDTO{
    public String id;

    public String name;
    public ModelCategory category;

    public String imageUrl;
    public Integer startYear;
    public Integer endYear;
    public String brand_name;

    public ModelOutputDTO(String name, ModelCategory category, String imageUrl, Integer startYear, Integer endYear, String brand_name) {
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand_name = brand_name;
    }

    public ModelOutputDTO() {
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

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    @Override
    public String toString() {
        return "ModelOutputDTO{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", brand_name='" + brand_name + '\'' +
                '}';
    }
}

