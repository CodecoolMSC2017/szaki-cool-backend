package com.codecool.web.service;

import com.codecool.web.model.Favourite;
import com.codecool.web.repository.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FavouriteService {

    @Autowired
    private FavouriteRepository favouriteRepository;

    public List<Favourite> getAll() {
        return favouriteRepository.findAll();
    }
}
