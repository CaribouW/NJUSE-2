package com.example.main.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Setter
@Getter
public class Role extends BaseDomain {
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_id", length = 64, unique = true)
    private String roleId;

    @ManyToMany()
    @JoinTable(name = "mapper_user_role",
            joinColumns = {
                    @JoinColumn(name = "role_id",
                            foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id",
                            foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
            })
    private List<User> users;


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
