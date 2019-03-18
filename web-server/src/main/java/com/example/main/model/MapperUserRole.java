package com.example.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mapper_user_role")
public class MapperUserRole extends BaseDomain{
    @Column(name = "user_id")
    private String uid;

    @Column(name = "role_id")
    private String rid;
}
