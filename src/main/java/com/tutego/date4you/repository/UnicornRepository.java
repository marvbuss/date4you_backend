package com.tutego.date4you.repository;

import com.tutego.date4you.domain.Unicorn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnicornRepository extends JpaRepository<Unicorn, Long> {

    Optional<Unicorn> findByUsername(String username);

}
