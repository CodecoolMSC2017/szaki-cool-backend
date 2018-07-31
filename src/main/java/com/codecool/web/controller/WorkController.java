package com.codecool.web.controller;

import com.codecool.web.dto.SimpleAdDto;
import com.codecool.web.model.Work;
import com.codecool.web.service.AdvertisementService;
import com.codecool.web.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public Work getById(@PathVariable("id") Integer id) {
       return workService.getById(id);
    }
}
