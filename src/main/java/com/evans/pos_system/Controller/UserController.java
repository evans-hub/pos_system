package com.evans.pos_system.Controller;

import com.evans.pos_system.Entity.Model;
import com.evans.pos_system.Entity.Role;
import com.evans.pos_system.Entity.User;
import com.evans.pos_system.Service.UserService;
import com.evans.pos_system.Service.UserServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok().body(userService.findAllUsers());
    }
    @PostMapping("/saveuser")
public User saveUser(@RequestBody Model user){
        return userService.saveUser(user);
}
public ResponseEntity<User> addRoleToUser(RR rr){
        userService.AddRoleToUser(rr.getEmail(), rr.getRolename());
        User role=userService.findUser(rr.getEmail());
        return ResponseEntity.ok().body(role);
}
}
@Data
class RR{
    private String rolename;
    private String email;
}
