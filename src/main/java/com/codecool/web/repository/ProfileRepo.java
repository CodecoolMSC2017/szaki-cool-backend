package com.codecool.web.repository;

import com.codecool.web.model.ProfileData;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepo extends CrudRepository<ProfileData, Long> {
}
