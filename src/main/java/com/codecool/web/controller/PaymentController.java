package com.codecool.web.controller;


import com.codecool.web.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/bid")
    Integer bid(@RequestBody Map<String, String> map) {
        Integer userId = Integer.parseInt(map.get("userId"));
        Integer workId = Integer.parseInt(map.get("workId"));
        Integer bid = Integer.parseInt(map.get("bid"));

        paymentService.placeBid(userId, workId, bid);
        return bid;
    }

    @PostMapping("/buy")
    void buy(@RequestBody Map<String, String> map) {

    }
}
