package com.codecool.web.service;


import com.codecool.web.dto.AdvertisementDetailsDto;
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

    public List<SimpleAdDto> getAdsByString(String string) {
        List<SimpleAdDto> simpleAdDtos = getSimpleDtos();
        List<SimpleAdDto> simpleAdDtosByString = new ArrayList<>();
        if (string.equals(null) || string.equals("")) {
            return simpleAdDtos;
        } else {
            for (SimpleAdDto temp : simpleAdDtos) {
                if (temp.getDescription().toLowerCase().contains(string) || temp.getDescription().toLowerCase().contains(string)) {
                    simpleAdDtosByString.add(temp);
                }
            }
            return simpleAdDtosByString;
        }
    }

    public List<SimpleAdDto> getAdsByCatPriceRating(String category, int minValue, int maxValue, float minRating, float maxRating){
        List<SimpleAdDto> simpleAdDtos = getSimpleDtos();
        List<SimpleAdDto> simpleAdDtosByCatPriceRating = new ArrayList<>();
        List<Work> works = workRepository.findAll();
        for (SimpleAdDto temp : simpleAdDtos) {
            for (Work work : works) {
                if (temp.getId().equals(work.getId()) && work.getCategory().equals(category) && temp.getPrice() >= minValue && temp.getPrice() <= maxValue && temp.getUserRating() >= minRating && temp.getUserRating() <= maxRating) {
                    simpleAdDtosByCatPriceRating.add(temp);
                }

            }
        }
        return simpleAdDtosByCatPriceRating;
    }

    public List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        List<Work> works = workRepository.findAll();
        for (Work temp : works) {
            if (categories.contains(temp.getCategory())) {
                continue;
            } else {
                categories.add(temp.getCategory());
            }
        }
        return categories;
    }


    public AdvertisementDetailsDto getAdvertisementDetails(Integer id){
        AdvertisementDetailsDto ad = new AdvertisementDetailsDto();
        Work work = workRepository.getOne(id);
        Integer userId = work.getContractor().getId();

        ad.setUserId(userId);
        ad.setUserName(work.getContractor().getUsername());
        ad.setCurrency(work.getCurrency().getCurrency());
        ad.setGarantee_length(work.getGuarantee_length().getGuarantee_length());
        ad.setGarantee_value(work.getGuarantee_value());
        ad.setNumberOfRatings(ratingRepository.getNumberOfRatings(userId));
        ad.setUserRating(ratingRepository.getAvarage(userId));
        ad.setPrice(work.getPrice());
        ad.setWorkTitle(work.getTitle());
        ad.setWorkDescription(work.getDescription());


        return ad;
    }
}

