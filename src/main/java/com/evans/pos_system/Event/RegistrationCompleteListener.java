package com.evans.pos_system.Event;

import com.evans.pos_system.Email.EmailService;
import com.evans.pos_system.Entity.User;
import com.evans.pos_system.Service.UserService;
import com.evans.pos_system.Service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Slf4j
@Component
public class RegistrationCompleteListener implements ApplicationListener<RegistrationCompleteEvent> {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        User user=event.getUser();
        String token= UUID.randomUUID().toString();
        userService.saveVerificationToken(user,token);
        String url= event.getApplicationurl()+"/api/verifyRegistrations?token="+token;
        log.info("Click the link {}",url);
        emailService.sendSimpleMessage(user.getEmail(), "Access token",url);

    }
}
