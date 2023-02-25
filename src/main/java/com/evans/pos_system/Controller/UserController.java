package com.evans.pos_system.Controller;

import com.evans.pos_system.DTO.CustomerDto;
import com.evans.pos_system.Email.EmailService;
import com.evans.pos_system.Entity.Model;
import com.evans.pos_system.Entity.User;
import com.evans.pos_system.Event.RegistrationCompleteEvent;
import com.evans.pos_system.Send;
import com.evans.pos_system.Service.UserServiceImpl;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;


@RestController
@RequestMapping("/api")

public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ApplicationEventPublisher publisher;
    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/users")
    public ResponseEntity<List<CustomerDto>> findAllUsers() {
        LOGGER.info("Inside find all users in user controller");
        return ResponseEntity.ok().body(userService.findAllUsers());
    }
    @GetMapping("/verifyRegistrations")
    public String verifyRegistration(@RequestParam("token") String token){
        String result=userService.verifyVerification(token);
        if (result.equalsIgnoreCase("valid")){
            return "User Verified Successfully";
        }
        return "Bad User";
    }

    @PostMapping("/saveuser")
    public ResponseEntity<User> saveUser(@RequestBody Model user, final HttpServletRequest request) {
        LOGGER.info("Inside save user in user controller");
        User user1 = userService.saveUser(user);
        publisher.publishEvent(new RegistrationCompleteEvent(user1, applicationUrl(request)));
        return ResponseEntity.ok().body(user1);
    }
    private String applicationUrl(HttpServletRequest request){
        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    }
    public ResponseEntity<User> addRoleToUser(RR rr) {
        userService.AddRoleToUser(rr.getEmail(), rr.getRolename());
        User role = userService.findUser(rr.getEmail());
        LOGGER.info("Inside adding role to user in user controller");
        return ResponseEntity.ok().body(role);
    }
}

@Data
class RR {
    private String rolename;
    private String email;
}
