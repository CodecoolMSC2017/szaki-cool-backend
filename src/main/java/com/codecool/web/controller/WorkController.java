package com.codecool.web.controller;

import com.codecool.web.dto.SimpleAdDto;
import com.codecool.web.model.Work;
import com.codecool.web.service.AdvertisementService;
import com.codecool.web.service.WorkService;
import com.codecool.web.service.exceptions.InsufficientDataProvidedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/simple")
    public List<SimpleAdDto> listSimple(){
        return advertisementService.getSimpleDtos();
    }

    @PostMapping("/addnew")
    public Work register(@RequestBody Map<String, String> map) {
        return workService.addWork(map);
    }

    @GetMapping("/{id}")
    public Work getById(@PathVariable("id") Integer id) {
       return workService.getById(id);
    }

    @GetMapping("searchname/{name}")
    public List<Work> getAdvByUserName(@PathVariable("name") String userName){
        return workService.findAllByUserName(userName);
    }

    @GetMapping("searchcategory/{category}")
    public List<Work> getAdvByCategory(@PathVariable("category") String category){
        return workService.findAllByCategory(category);
    }
}
