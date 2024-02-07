package com.example.electrostore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name="roles")
@Data
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @OneToMany(mappedBy = "role")// tên thuộc tính  của entity
    private List<UserEntity> users;

}
