package com.codecool.web.service;

import com.codecool.web.model.Bid;
import com.codecool.web.model.Work;
import com.codecool.web.repository.BidRepository;
import com.codecool.web.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private WorkRepository workRepository;


    public void placeBid(Integer user_id, Integer work_id, Integer bid) {
        Bid newBid = new Bid();
        newBid.setUserId(user_id);
        newBid.setWork_id(work_id);
        Work work = workRepository.findById(work_id).get();
        work.setPrice(bid);
        workRepository.save(work);
        bidRepository.save(newBid);
    }

    @Scheduled(fixedRate=5000)
    void checkWinners() {

    }
}
