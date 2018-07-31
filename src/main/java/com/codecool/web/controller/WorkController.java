package com.codecool.web.controller;

import com.codecool.web.dto.SimpleAdDto;
import com.codecool.web.model.Work;
import com.codecool.web.service.AdvertisementService;
import com.codecool.web.service.WorkService;
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

    @GetMapping("/simple")
    public List<SimpleAdDto> listSimple(){
        return advertisementService.getSimpleDtos();
    }

    @PostMapping("/addnew")
    public Work register(@RequestBody Map<String, String> map) {
        return workService.addWork(map);
    }
}
