package com.example.cross_currency_risk.controller;


import com.example.cross_currency_risk.domain.User;
import com.example.cross_currency_risk.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService)
    {
        this.userService=userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String,String> req){
        User user = userService.register(
             req.get("name"),
             req.get("email"),
             req.get("password"),
             req.get("role")
        );

        return ResponseEntity.ok(Map.of(
                "id",user.getId(),
                "email",user.getEmail(),
                "role",user.getRole()
        ));
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> req){
        User user = userService.login(req.get("email"),req.get("password"));

        return ResponseEntity.ok(Map.of(
                "message","Login successfull",
                "user",user.getName(),
                "role",user.getRole()
        ));
    }
}
