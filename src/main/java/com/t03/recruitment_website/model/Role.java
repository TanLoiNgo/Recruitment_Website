package com.t03.recruitment_website.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long role_ID;

    @Column(name = "role_name", unique = true)
    private String role_name;

    @ManyToMany(mappedBy="roles")
    private Set<Users> users = new HashSet<>();

    public Role() {
    }

    public Role( String role_name) {
        this.role_name = role_name;
    }

    public Long getRole_ID() {
        return role_ID;
    }

    public void setRole_ID(Long role_ID) {
        this.role_ID = role_ID;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
