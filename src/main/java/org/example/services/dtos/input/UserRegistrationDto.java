package org.example.services.dtos.input;

import jakarta.validation.constraints.*;
import org.example.util.customValidators.annotations.UniqueUsername;

public class UserRegistrationDto {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String confirmPassword;

    public UserRegistrationDto() {}
    public void setUsername(String username) {
        this.username = username;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @UniqueUsername
    @NotEmpty(message = "User name cannot be null or empty!")
    @Size(min = 4, max = 20)
    public String getUsername() {
        return username;
    }
    @NotEmpty(message = "First name cannot be null or empty!")
    @Size(min = 1, max = 20)
    public String getFirstName() {
        return firstName;
    }
    @NotEmpty(message = "Last name cannot be null or empty!")
    @Size(min = 1, max = 20)
    public String getLastName() {
        return lastName;
    }
    @NotEmpty(message = "Password cannot be null or empty!")
    @Size(min = 5, max = 20)
    public String getPassword() {
        return password;
    }
    @NotEmpty(message = "Confirm Password cannot be null or empty!")
    @Size(min = 5, max = 20)
    public String getConfirmPassword() {
        return confirmPassword;
    }
    @AssertTrue(message = "Passwords do not match")
    public boolean getIsPasswordsMatch() {
        return password != null && password.equals(confirmPassword);
    }

    @Override
    public String toString() {
        return "UserRegistrationDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
