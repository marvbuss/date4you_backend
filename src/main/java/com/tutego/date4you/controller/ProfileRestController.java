package com.tutego.date4you.controller;


import com.tutego.date4you.domain.Profile;
import com.tutego.date4you.domain.Unicorn;

import com.tutego.date4you.service.UserDetailsServiceImpl;

import org.springframework.http.ResponseEntity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileRestController {

    private final UserDetailsServiceImpl userDetailsService;

    public ProfileRestController(UserDetailsServiceImpl userDetailsService) {

        this.userDetailsService = userDetailsService;
    }

    @GetMapping("profile")
    public ResponseEntity<?> getProfile(@AuthenticationPrincipal Unicorn unicorn) {
        Unicorn currentUser = (Unicorn) userDetailsService.loadUserByUsername(unicorn.getUsername());
        Profile currentProfile = currentUser.getProfile();
        return ResponseEntity.ok().body(currentProfile);
    }

}
