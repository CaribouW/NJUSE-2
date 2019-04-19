package com.example.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "mapper_user_role")
public class MapperUserRole implements Serializable {
    @Column(name = "user_id")
    private String uid;

    @Column(name = "role_id")
    private String rid;
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
