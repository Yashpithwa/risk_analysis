package com.example.cross_currency_risk.service;


import com.example.cross_currency_risk.domain.Role;
import com.example.cross_currency_risk.domain.User;
import com.example.cross_currency_risk.repository.RoleRepository;
import com.example.cross_currency_risk.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository,RoleRepository roleRepository){
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
    }

    public User register(String name,String email,String password,String roleName){

        Role role = roleRepository.findByName(roleName)
                .orElseGet(()->roleRepository.save(new Role(roleName)));

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        user.setRole(role);

        return userRepository.save(user);
    }

    public User login(String email,String password){
        User user = userRepository.findByEmail(email)
                .orElseThrow(()->new RuntimeException("User not found"));

        if(!encoder.matches(password,user.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        return user;
    }

}
