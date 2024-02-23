package com.example.electrostore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phonenumber")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private RoleEntity role;

}
