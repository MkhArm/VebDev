package org.example.services.dtos.output;

import org.example.models.enums.UserRoleType;
import org.example.services.dtos.baseEntities.BaseEntityDTO;

public class UserOutputDTO extends BaseEntityDTO {

    private String username;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private String imageUrl;
    private UserRoleType role;

    public UserOutputDTO(String username, String firstName, String lastName, Boolean isActive, String imageUrl, UserRoleType role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
        this.role = role;
    }

    public UserOutputDTO() {
    }

    public void setUsername(String username) {
        this.username = username;
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
    public void setRole(UserRoleType role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Boolean getActive() {
        return isActive;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public UserRoleType getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "UserOutputDTO{" +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", imageUrl='" + imageUrl + '\'' +
                ", role=" + role +
                '}';
    }
}

