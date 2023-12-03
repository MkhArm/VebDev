package org.example.services.dtos.input;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

