package com.sec.practice.oauth.persistence.entities.sec;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="role")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
    private List<GrantedPermission> permissions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GrantedPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<GrantedPermission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}