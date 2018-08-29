package com.codecool.web.controller;


import com.codecool.web.model.GuaranteeLength;
import com.codecool.web.repository.GuaranteeLengthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuaranteeController {

    @Autowired
    GuaranteeLengthRepository GuaranteeLengthRepository;

    @GetMapping("/guarantee_length/all")
    Iterable<GuaranteeLength> getAll() {
        return GuaranteeLengthRepository.findAll();
    }
}
