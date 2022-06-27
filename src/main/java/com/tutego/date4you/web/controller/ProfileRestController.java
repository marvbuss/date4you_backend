package com.tutego.date4you.web.controller;


import com.tutego.date4you.core.entities.Profile;
import com.tutego.date4you.core.entities.Unicorn;

import com.tutego.date4you.service.ProfileService;
import com.tutego.date4you.service.UserDetailsServiceImpl;

import org.springframework.http.ResponseEntity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileRestController {

    private final UserDetailsServiceImpl userDetailsService;
    private final ProfileService profileService;

    public ProfileRestController(UserDetailsServiceImpl userDetailsService, ProfileService profileService) {
        this.profileService = profileService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("profile")
    public ResponseEntity<?> getProfile(@AuthenticationPrincipal Unicorn unicorn) {
        Unicorn currentUser = (Unicorn) userDetailsService.loadUserByUsername(unicorn.getUsername());
        Profile currentProfile = currentUser.getProfile();
        return ResponseEntity.ok().body(currentProfile);
    }

    @GetMapping("profile/{id}")
    public ResponseEntity<?> getOtherProfile(@AuthenticationPrincipal Unicorn unicorn, @PathVariable("id") Long profileId) {
        Optional<Profile> otherProfile = profileService.getProfile(profileId);
        return ResponseEntity.ok().body(otherProfile);
    }

    @GetMapping("matches")
    public ResponseEntity<?> getMatches(@AuthenticationPrincipal Unicorn unicorn, @RequestParam int minAge, @RequestParam int maxAge, @RequestParam short minHornlength, @RequestParam short maxHornlength, @RequestParam int gender) {
        List<Profile> matches = profileService.getProfiles(minAge, maxAge, minHornlength, maxHornlength, gender);
        return ResponseEntity.ok().body(matches);
    }

}
