package org.example.services.dtos.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.models.enums.UserRoleType;
import org.example.util.customValidators.annotations.PasswordConstraint;
import org.example.util.customValidators.annotations.UsernameConstraint;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

public class UserDTO {
    private String id;

    @UsernameConstraint
    private String username;

    @PasswordConstraint
    private String password;

    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @NotNull(message = "Is active cannot be null")
    private Boolean isActive;

    @NotBlank(message = "Image URL cannot be blank")
    private String imageUrl;
    @NotNull(message = "Role cannot be null")
    private UserRoleType role;

    public UserDTO(String username, String password, String firstName, String lastName, Boolean isActive, String imageUrl, UserRoleType role) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
        this.role = role;
    }

    public UserDTO(String username, String password, String firstName, String lastName, Boolean isActive, String imageUrl) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
        this.role = UserRoleType.USER;
    }

    public UserDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public UserRoleType getRole() {
        return role;
    }

    public void setRole(UserRoleType role) {
        this.role = role;
    }
}

