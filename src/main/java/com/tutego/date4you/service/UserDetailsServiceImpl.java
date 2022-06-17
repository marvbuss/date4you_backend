package com.tutego.date4you.service;

import com.tutego.date4you.domain.Profile;
import com.tutego.date4you.domain.Unicorn;
import com.tutego.date4you.repository.UnicornRepository;
import com.tutego.date4you.util.CustomPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    final private CustomPasswordEncoder passwordEncoder;

    private final UnicornRepository unicornRepository;

    public UserDetailsServiceImpl(CustomPasswordEncoder passwordEncoder, UnicornRepository unicornRepository) {
        this.passwordEncoder = passwordEncoder;
        this.unicornRepository = unicornRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Unicorn> byEmailOpt = unicornRepository.findByUsername(username);

        return byEmailOpt.orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
    }

    public UserDetails createUserByEmail(String email, String password, LocalDate birthdate, String nickname, short hornlength, byte gender, String description, LocalDateTime lastseen){
        Unicorn newUnicorn = new Unicorn();
        Profile newProfile = new Profile();

        newUnicorn.setEmail(email);

        String encodedPassword = passwordEncoder.getPasswordEncoder().encode(password);
        newUnicorn.setPassword(encodedPassword);
        newUnicorn.setUsername(email);
        newProfile.setBirthdate(birthdate);
        newProfile.setNickname(nickname);
        newProfile.setHornlength(hornlength);
        newProfile.setGender(gender);
        newUnicorn.setProfile(newProfile);

        Unicorn savedUnicorn = unicornRepository.save(newUnicorn);

        return savedUnicorn;
    }
}
