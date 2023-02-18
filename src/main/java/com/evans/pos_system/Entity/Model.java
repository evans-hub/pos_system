package com.evans.pos_system.Entity;

import lombok.Data;

@Data
public class Model {
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private Role role;
    private boolean status;
}
