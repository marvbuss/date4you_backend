package com.tutego.date4you.controller;

import com.tutego.date4you.domain.Unicorn;
import com.tutego.date4you.model.AuthCredentialsRequest;
import com.tutego.date4you.model.UnicornProfileFormDataRequest;
import com.tutego.date4you.service.UserDetailsServiceImpl;
import com.tutego.date4you.util.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    private final UserDetailsServiceImpl userDetailsService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserDetailsServiceImpl userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody AuthCredentialsRequest request) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getUsername(), request.getPassword()
                            )
                    );

            Unicorn unicorn = (Unicorn) authenticate.getPrincipal();

            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.AUTHORIZATION,
                            jwtUtil.generateToken(unicorn)
                    )
                    .body(unicorn);
            // TODO: 16.06.2022 remove password from response header
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("registration")
    public ResponseEntity<?> registration(@RequestBody UnicornProfileFormDataRequest request) {
        UserDetails newUnicorn = userDetailsService.createUser(request.getEmail(), request.getPassword(), request.getBirthdate(), request.getNickname(), request.getHornlength(), request.getGender(), request.getAttractedToGender(), request.getDescription());
        return ResponseEntity.ok().body(newUnicorn);
    }

}