package com.bootcamp.project.ecommerceapplication.domain;


import com.bootcamp.project.ecommerceapplication.models.RoleModel;
import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String authority;



    public Role() {
    }

    public Role(RoleModel roleModel){
        this.id = roleModel.getId();
        this.authority = roleModel.getAuthority();
    }

    public Role(long id, String authority, List<User> users) {
        this.id = id;
        this.authority = authority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }


}
