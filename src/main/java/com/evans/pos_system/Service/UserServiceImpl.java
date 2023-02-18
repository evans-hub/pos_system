package com.evans.pos_system.Service;
import com.evans.pos_system.Entity.Model;
import com.evans.pos_system.Entity.Role;
import com.evans.pos_system.Entity.User;
import com.evans.pos_system.Exceptions.UserNotFoundException;
import com.evans.pos_system.Repository.RoleRepository;
import com.evans.pos_system.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
  /*  @Autowired
    private BCryptPasswordEncoder passwordEncoder;*/
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(Model model) {
        User user=new User();
        user.setEmail(model.getEmail());
        user.setPhoneNumber(model.getPhoneNumber());
        user.setUsername(model.getUsername());
        user.setStatus(true);
        user.setPassword(model.getPassword());
      //  user.setPassword(passwordEncoder.encode(model.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findUser(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User deleteUser(String email) throws UserNotFoundException {
        User user=userRepository.findByEmail(email);
        if (user!=null){
            userRepository.delete(user);
        }
        else {
            throw new UserNotFoundException("User With id {} not found");
        }
        return user;
    }

    @Override
    public User updateUser(String email) {
        return null;
    }

    @Override
    public void AddRoleToUser(String email,String rolename) {
User user=userRepository.findByEmail(email);
Role role=roleRepository.findRoleByName(rolename);
user.getRoles().add(role);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }


}
