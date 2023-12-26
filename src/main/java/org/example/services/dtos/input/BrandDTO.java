package org.example.services.dtos.input;

import jakarta.validation.constraints.NotBlank;

public class BrandDTO{

    private String id;
    private String name;

    public BrandDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public BrandDTO() {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @NotBlank(message = "Brand name cannot be blank")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

