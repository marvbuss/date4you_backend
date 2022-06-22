package com.tutego.date4you.shell;

import com.tutego.date4you.domain.Photo;
import com.tutego.date4you.repository.ProfileRepository;
import com.tutego.date4you.repository.UnicornRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.time.LocalDateTime;

@ShellComponent
public class RepositoryCommands {

    @Autowired
    private ProfileRepository profiles;

    @Autowired
    private UnicornRepository unicorns;

    @ShellMethod("Lists all profiles")
    public void list() {
        profiles.findAll().forEach(System.out::println);
    }

    @ShellMethod("save photo")
    public void savePhoto(String photoPath, String profileId) {
        Photo newPhoto = new Photo();
        newPhoto.setCreated(LocalDateTime.now());
        newPhoto.setName(photoPath);
        newPhoto.setProfilePhoto(false);
        profiles.findById(Long.valueOf(profileId)).ifPresent(profile -> {
            profile.getPhotos().add(newPhoto);
            newPhoto.setProfile(profile);
            profiles.save(profile);
        });
    }
}
