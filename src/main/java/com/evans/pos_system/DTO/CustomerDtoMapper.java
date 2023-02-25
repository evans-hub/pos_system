package com.evans.pos_system.DTO;

import com.evans.pos_system.Entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class CustomerDtoMapper implements Function<User,CustomerDto> {
    @Override
    public CustomerDto apply(User user) {
        return new CustomerDto(user.getId(), user.getUsername(), user.getEmail(), user.getPhoneNumber());
    }


}
