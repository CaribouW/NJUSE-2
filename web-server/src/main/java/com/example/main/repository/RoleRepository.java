package com.example.main.repository;

import com.example.main.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, String> {
    @Query("select r from Role as r where r.roleId = ?1")
    Role findByRoleId(String role_id);
}
