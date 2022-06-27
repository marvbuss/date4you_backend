package com.tutego.date4you.core.repository;

import com.tutego.date4you.core.entities.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

    @Query( """
    SELECT p
    FROM   Profile p
    WHERE  (p.birthdate  BETWEEN :minBirthdate  AND :maxBirthdate)
       AND (p.hornlength BETWEEN :minHornlength AND :maxHornlength)
       AND (p.gender = :gender) """ )
    List<Profile> search(LocalDate minBirthdate, LocalDate maxBirthdate,
                         short minHornlength, short maxHornlength, byte gender);

}
