package com.codecool.web.repository;

import com.codecool.web.model.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavouriteRepository extends JpaRepository<Favourite, Integer> {

    List<Favourite> findByUserId(Integer userId);
}
