package org.example.models.entities;

import jakarta.persistence.*;
import org.example.models.baseEntities.TimestampedEntity;

import java.util.*;

@Entity
@Table(name = "users")

public class User extends TimestampedEntity {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRole role;
    @OneToMany(mappedBy = "seller", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Offer> offers = new ArrayList<>();

    public User(String username, String password,
                String firstName, String lastName, Boolean isActive, String imageUrl, UserRole role) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
        this.role = role;
    }
    public User() {
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setActive(Boolean active) {
        isActive = active;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }
    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @Column(name = "username", length = 255, nullable = false)
    public String getUsername() {
        return username;
    }
    @Column(name = "password", length = 255, nullable = false)
    public String getPassword() {
        return password;
    }
    @Column(name = "firstName", length = 255, nullable = false)
    public String getFirstName() {
        return firstName;
    }
    @Column(name = "lastName", length = 255, nullable = false)
    public String getLastName() {
        return lastName;
    }
    @Column(name = "isActive")
    public Boolean getActive() {
        return isActive;
    }
    @Column(name = "imageUrl", length = 512, nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public UserRole getRole() {
        return role;
    }

    public List<Offer> getOffers() {
        return offers;
    }
}
