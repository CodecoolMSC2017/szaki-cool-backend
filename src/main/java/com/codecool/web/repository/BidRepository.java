package com.codecool.web.repository;

import com.codecool.web.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BidRepository extends JpaRepository<Bid, Integer> {
    Bid findByWorkIdAndBid(Integer workId, Integer bid);
}
