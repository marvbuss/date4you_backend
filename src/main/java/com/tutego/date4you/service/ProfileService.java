package com.tutego.date4you.service;

import com.tutego.date4you.domain.Profile;
import com.tutego.date4you.repository.ProfileRepository;
import com.tutego.date4you.repository.UnicornRepository;
import com.tutego.date4you.util.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    public List<Profile> getProfiles(int minAge, int maxAge,
                                                       short minHornlength, short maxHornlength,
                                                       int gender) {
        LocalDate currentDate = LocalDate.now();

        return profileRepository.search(
                        currentDate.minusYears(maxAge), currentDate.minusYears(minAge),
                        minHornlength,
                        maxHornlength, (byte) gender);
    }
}
