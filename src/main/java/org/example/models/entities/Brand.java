package org.example.models.entities;

import jakarta.persistence.*;
import org.example.models.baseEntities.TimestampedEntity;

import java.util.*;

@Entity
@Table(name = "brands")

public class Brand extends TimestampedEntity {

    private String name;
    @OneToMany(mappedBy = "brand", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Model> models = new ArrayList<>();

    public Brand(String name) {
        this.name = name;
    }
    public Brand() {
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setModels(List<Model> models) {
        this.models = models;
    }

    @Column(name = "name", length = 255, nullable = false)
    public String getName() {
        return name;
    }
    public List<Model> getModels() {
        return models;
    }
}
