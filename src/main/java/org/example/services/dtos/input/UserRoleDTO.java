package org.example.services.dtos.input;

import jakarta.validation.constraints.NotNull;
import org.example.models.enums.UserRoleType;
import org.example.util.customValidators.annotations.UserRoleConstraint;

import java.util.UUID;
@UserRoleConstraint
public class UserRoleDTO {
    private String id;
    private UserRoleType role;

    public UserRoleDTO(UserRoleType role) {
        this.role = role;
    }
    public UserRoleDTO() {
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setRole(UserRoleType role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }
    @NotNull(message = "Role cannot be null")
    public UserRoleType getRole() {
        return role;
    }
}
