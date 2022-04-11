package com.bootcamp.project.ecommerceapplication.models;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UserModel {


    @Email(message = "invalid email enter valid email")
    private String email;
    @NotBlank(message = "first name cannot be empty")
    @NotNull
    private String firstName;
    @NotNull(message = "middle name cannot be null")
    private String middleName;
    @NotNull(message = "last name cannot be null")
    private String lastName;
    @NotNull
    @NotBlank(message = "password is mandatory")
    private String password;
    @NotNull
    @NotBlank(message = "it should be same like password")
    private String confirmPassword;
    private List<Long> roles;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<Long> getRoles() {
        return roles;
    }

    public void setRoles(List<Long> roles) {
        this.roles = roles;
    }
}
