package org.example.services.dtos.output;

public class BrandModelCountDTO {
    private String name;
    private Long сount;

    public BrandModelCountDTO(String name, Long сount) {
        this.name = name;
        this.сount = сount;
    }
    public BrandModelCountDTO() {
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setСount(Long сount) {
        this.сount = сount;
    }

    public String getName() {
        return name;
    }
    public Long getСount() {
        return сount;
    }
}
