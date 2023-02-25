package com.evans.pos_system.Service;


import com.evans.pos_system.DTO.CustomerDto;
import com.evans.pos_system.Entity.Model;
import com.evans.pos_system.Entity.Role;
import com.evans.pos_system.Entity.User;
import com.evans.pos_system.Exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<CustomerDto> findAllUsers();

    User saveUser(Model user);

    User findUser(String email);

    User deleteUser(String email) throws UserNotFoundException;

    User updateUser(String email);

    void AddRoleToUser(String email,String rolename);

    Role saveRole(Role role);
    void saveVerificationToken(User user,String token);

    String verifyVerification(String token);
}
