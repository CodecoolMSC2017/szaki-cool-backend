package com.codecool.web.service;


import com.codecool.web.dto.SimpleAdDto;
import com.codecool.web.model.Work;
import com.codecool.web.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertisementService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    WorkRepository workRepository;

    @Autowired
    PictureRepository pictureRepository;

    @Autowired
    ProfileService profileService;

    public List<SimpleAdDto> getSimpleDtos() {
        List<Work> works;
        List<SimpleAdDto> dtos = new ArrayList<>();
        works = workRepository.findAll();
        for(Work work: works) {
            SimpleAdDto dto = new SimpleAdDto();
            dto.setDescription(work.getDescription());
            dto.setUserName(work.getContractor().getUsername());
            dto.setPrice(work.getPrice());

            Integer userId = work.getContractor().getId();

            dto.setId(work.getId());
            dto.setUserRating(ratingRepository.getAvarage(userId));
            dto.setNumberOfRatings(ratingRepository.getNumberOfRatings(userId));
            dto.setWorkImgUrl(pictureRepository.findByworkIdAndPromotedTrue(work.getId()).getName());
            dto.setUserImgUrl(profileService.findByUserId(userId).getPicture());
            dtos.add(dto);
        }
        return dtos;
    }
}
