package com.evans.pos_system.Event;

import com.evans.pos_system.Entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private User user;
    private String applicationurl;
    public RegistrationCompleteEvent(User user,String applicationurl) {
        super(user);
        this.user=user;
        this.applicationurl=applicationurl;

    }
}
