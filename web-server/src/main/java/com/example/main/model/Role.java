package com.example.main.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "role")
@Setter
@Getter
public class Role implements Serializable {
    @Column(name = "role_name")
    private String roleName;
    @Id
    @Column(name = "role_id", length = 64, unique = true)
    private String roleId;

    private Timestamp expireTime;

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Id
    @Column(name = "role_id")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "expire_time")
    public Timestamp getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(roleName, role.roleName) &&
                Objects.equals(roleId, role.roleId) &&
                Objects.equals(expireTime, role.expireTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, expireTime);
    }
}
