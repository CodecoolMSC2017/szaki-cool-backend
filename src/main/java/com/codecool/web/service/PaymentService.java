package com.codecool.web.service;

import com.codecool.web.model.Bid;
import com.codecool.web.model.Work;
import com.codecool.web.repository.BidRepository;
import com.codecool.web.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
        newBid.setBid(bid);
        Work work = workRepository.findById(work_id).get();
        work.setPrice(bid);
        workRepository.save(work);
        bidRepository.save(newBid);
    }


    @Scheduled(fixedRate=5000)
    void checkWinners() throws ParseException {
        List<Work> works = workRepository.findByIsActiveTrueAndBidTrue();
        Date now = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Work work: works) {
            Date expireDate = format.parse(work.getBid_expire_date());
            int comp = now.compareTo(expireDate);
            if (comp > 0) {
                work.setActive(false);
                workRepository.save(work);
                if (! work.getWinnerNotified()) {
                    notifyWinner();
                }
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        String expireDate = "2019-07-03 00:00:00";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(expireDate);
        System.out.println(date);
    }

    void notifyWinner() {
    }
}
