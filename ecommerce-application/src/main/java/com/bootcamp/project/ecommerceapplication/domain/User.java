package com.bootcamp.project.ecommerceapplication.domain;

import com.bootcamp.project.ecommerceapplication.aware.ApplicationContextHolder;
import com.bootcamp.project.ecommerceapplication.models.UserModel;
import com.bootcamp.project.ecommerceapplication.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private boolean is_deleted;
    private boolean is_active;
    private boolean is_expired;
    private boolean is_locked;
    private int invalid_attempt_count;
    private Date password_update_date;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;


    public User() {
    }

    public User(UserModel userModel){
        if(userModel != null){
            this.firstName = userModel.getFirstName();
            this.middleName = userModel.getMiddleName();
            this.lastName = userModel.getLastName();
            this.email = userModel.getEmail();
            this.password = userModel.getPassword();

        }
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public boolean isIs_expired() {
        return is_expired;
    }

    public void setIs_expired(boolean is_expired) {
        this.is_expired = is_expired;
    }

    public boolean isIs_locked() {
        return is_locked;
    }

    public void setIs_locked(boolean is_locked) {
        this.is_locked = is_locked;
    }

    public int getInvalid_attempt_count() {
        return invalid_attempt_count;
    }

    public void setInvalid_attempt_count(int invalid_attempt_count) {
        this.invalid_attempt_count = invalid_attempt_count;
    }

    public Date getPassword_update_date() {
        return password_update_date;
    }

    public void setPassword_update_date(Date password_update_date) {
        this.password_update_date = password_update_date;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private static UserRepository getUserRepository() {
        return ApplicationContextHolder.getBean(UserRepository.class);
    }
    public static User findByEmail(String email) {
        return getUserRepository().findByEmail(email);
    }

    public static User currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            return User.findByEmail(authentication.getName());
        }
        return null;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", is_deleted=" + is_deleted +
                ", is_active=" + is_active +
                ", is_expired=" + is_expired +
                ", is_locked=" + is_locked +
                ", invalid_attempt_count=" + invalid_attempt_count +
                ", password_update_date=" + password_update_date +
                ", roles=" + roles +
                ", address=" + address +
                '}';
    }
}
