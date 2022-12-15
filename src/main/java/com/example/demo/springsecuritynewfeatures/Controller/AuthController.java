package com.example.demo.springsecuritynewfeatures.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springsecuritynewfeatures.Repository.UserDao;
import com.example.demo.springsecuritynewfeatures.Util.JwtUtils;
import com.example.demo.springsecuritynewfeatures.dto.AuthenticationRequest;
import com.example.demo.springsecuritynewfeatures.service.IAccountService;

@RestController
@RequestMapping("/api/v2/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private   IAccountService accountService;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationRequest request) {

        System.out.println("im authenticateing : " + request);

        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                        request.getPassword()));
        final UserDetails user = accountService.loadUserByUsername(request.getUsername());
        System.out.println("we found somtheing : " + user);
        if (user != null) {
            return ResponseEntity.ok(jwtUtils.generateToken(user));
        }
        return ResponseEntity.status(400).body("Some error has occured");

    }

}
