package com.evans.pos_system.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model {
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private Role role;
    private boolean status;
}
