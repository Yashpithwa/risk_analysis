package com.example.cross_currency_risk.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;
import java.util.SimpleTimeZone;

@RestController
public class HealthController {


    @GetMapping("/api/health")
    public ResponseEntity<Map<String,Object>> health(){
        return ResponseEntity.ok(Map.of(
                "app","cross-currency-risk",
                "status","UP",
                "timestamp", Instant.now().toString()
        ));
    }

    @GetMapping("/")
    public ResponseEntity<String> root(){
        return ResponseEntity.ok("Cross-currency Risk - Backend Running");
    }

}
