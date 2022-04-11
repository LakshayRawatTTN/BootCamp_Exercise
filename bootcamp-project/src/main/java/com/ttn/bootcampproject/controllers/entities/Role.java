package com.ttn.bootcampproject.controllers.entities;

import com.ttn.bootcampproject.enums.Authority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Role {

    @Id
    private long id;
    private Authority authority;
    @ManyToMany(mappedBy = "roles")
    List<User> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
