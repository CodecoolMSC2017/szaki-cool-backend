package com.codecool.web.repository;

import com.codecool.web.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer>{

    Optional<Profile> findByUserId(Integer userId);

    List<Profile> findAll();
}
