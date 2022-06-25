package com.tutego.date4you.service;

import com.tutego.date4you.domain.Profile;
import com.tutego.date4you.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public Optional<Profile> getProfile(long profileId){
        return profileRepository.findById(profileId);
    }
}
