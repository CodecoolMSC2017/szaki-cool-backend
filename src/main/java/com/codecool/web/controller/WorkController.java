package com.codecool.web.controller;

import com.codecool.web.dto.AdvertisementDetailsDto;
import com.codecool.web.dto.SimpleAdDto;
import com.codecool.web.model.Work;
import com.codecool.web.service.AdvertisementService;
import com.codecool.web.service.WorkService;
import com.codecool.web.service.exceptions.InsufficientDataProvidedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/works")
public class WorkController {

    @Autowired
    AdvertisementService advertisementService;

    @Autowired
    private WorkService workService;

    @GetMapping("")
    List<Work> getAll() {
        return workService.getAll();
    }

    // Have to handle when no picture on the ads! eg: default pic
    @GetMapping("/simple")
    public List<SimpleAdDto> listSimple(){
        return advertisementService.getSimpleDtos();
    }

    @PostMapping("/addnew")
    public Work register(@RequestBody Map<String, String> map) throws InsufficientDataProvidedException {
        return workService.addWork(map);
    }

    @GetMapping("/works/{id}")
    public Work getById(@PathVariable("id") Integer id) {
        return workService.getById(id);
    }

    @GetMapping("/details/{id}")
    public AdvertisementDetailsDto getDetailsById(@PathVariable("id") Integer id) {
        return advertisementService.getAdvertisementDetails(id);
    }

    @GetMapping("/search/{str}")
    public List<SimpleAdDto> getByString(@PathVariable("str") String string) {
        return advertisementService.getAdsByString(string);
    }

    @GetMapping("/categories")
    public List<String> getCategories() {
        return advertisementService.getCategories();
    }

    @GetMapping("search/name/{name}")
    public List<Work> getAdvByUserName(@PathVariable("name") String userName){
        return workService.findAllByUserName(userName);
    }

    @GetMapping("/my/{userId}")
    public List<SimpleAdDto> getMyAds(@PathVariable("userId") int userId){
        return advertisementService.getMyWorks(userId);
    }

    @GetMapping("search/{str}/{category}/{min}/{max}/{minRating}/{maxRating}")
    public List<SimpleAdDto> getAdsByCatPriceRating(@PathVariable("str") String str, @PathVariable("category") String category, @PathVariable("min") String minValue, @PathVariable("max") String maxValue, @PathVariable("minRating") String minRating, @PathVariable("maxRating") String maxRating){
        return advertisementService.getAdsByCatPriceRating(str, category, minValue, maxValue, minRating, maxRating);
    }

    @GetMapping("/favourite/{userId}")
    public List<SimpleAdDto> getFavourite(@PathVariable("userId") int userId){
        return advertisementService.getFavourites(userId);
    }

    @GetMapping("/isfavourite/{userId}/{workId}")
    public boolean getFavourite(@PathVariable("userId") int userId, @PathVariable("workId") int workId){
        return advertisementService.isFavourite(userId, workId);
    }

    @GetMapping("/add/favourite/{userId}/{workId}")
    public boolean addFavourite(@PathVariable("userId") int userId, @PathVariable("workId") int workId){
        return advertisementService.addFavourite(userId, workId);
    }

    @GetMapping("/remove/favourite/{userId}/{workId}")
    public boolean removeFavourite(@PathVariable("userId") int userId, @PathVariable("workId") int workId){
        return advertisementService.removeFavourite(userId, workId);
    }

    @GetMapping("search/category/{category}")    ///similar method in Searchcontroller, delete this later
    public List<Work> getAdvByCategory(@PathVariable("category") String category){
        return workService.findAllByCategory(category);
    }

    @GetMapping("search/catandname/{name}/{category}")
    public List<Work> getAdvByNameAndCategory(@PathVariable("category") String category, @PathVariable("name") String userName){
        return workService.findByCategoryAndUserName(userName, category);
    }
}

