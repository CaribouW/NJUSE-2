package com.example.main.repository;

import com.example.main.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends BaseRepository<Role> {
    Role findRoleByRoleName(String name);

    @Query(value = "select * from role r where r.role_id in (select m.role_id from mapper_user_role m where m.user_id = :uid)",nativeQuery = true)
    Role findRoleByUserID(@Param(value = "uid") String uid);
}
