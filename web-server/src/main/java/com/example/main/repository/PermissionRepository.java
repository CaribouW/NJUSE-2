package com.example.main.repository;

import com.example.main.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends BaseRepository<Permission> {
    /**
     * 根据roleId得到所有权限
     */
    List<Permission> findPermissionsByRoleId(String roleId);

}
