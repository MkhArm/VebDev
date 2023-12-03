package org.example.models.baseEntities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string",
            strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
