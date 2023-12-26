package org.example.models.baseEntities;

import jakarta.persistence.*;
import org.hibernate.annotations.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class TimestampedEntity extends BaseEntity {
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime modified;

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
    @Column(name = "created", updatable = false)
    public LocalDateTime getCreated() {
        return created;
    }
    @Column(name = "modified")
    public LocalDateTime getModified() {
        return modified;
    }
}

