package com.example.demo.springsecuritynewfeatures.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greeting")
public class greetingController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from Api");
    }

    @GetMapping("/say-good-bye")
    public ResponseEntity<String> saygoodBYe() {
        return ResponseEntity.ok("Good by and see you later");
    }

}
