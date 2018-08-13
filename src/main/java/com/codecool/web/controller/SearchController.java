package com.codecool.web.controller;

import com.codecool.web.dto.StringDto;
import com.codecool.web.model.Work;
import com.codecool.web.repository.WorkRepository;
import com.codecool.web.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    WorkService workService;


    @GetMapping("autofill/{keyword}")
    public List<StringDto> getAdvByCategory(@PathVariable("keyword") String keyword){
        return workService.searchAutofill(keyword);
    }
}
