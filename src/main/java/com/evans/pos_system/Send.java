package com.evans.pos_system;

import org.springframework.stereotype.Component;

@Component
public class Send {


    public String sendMessage(String message, String secret){
        String meso=message.concat(secret);
        return meso;
    }
}
