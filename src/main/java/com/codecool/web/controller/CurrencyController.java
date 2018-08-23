package com.codecool.web.controller;


import com.codecool.web.model.Currency;
import com.codecool.web.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Null;
import java.util.List;

@RestController
public class CurrencyController {

    @Autowired
    CurrencyRepository currencyRepository;

    @GetMapping("/currency/all")
    Iterable<Currency> getAll() {
        return currencyRepository.findAll();
    }
}
