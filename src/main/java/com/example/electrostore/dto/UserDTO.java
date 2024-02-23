package com.example.electrostore.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private int id;
    private String fullname;
    private String email;
    private String password;
    private String phone;
    private String role;

}
