package com.codecool.web.repository;

import com.codecool.web.model.User;
import com.codecool.web.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkRepository extends JpaRepository<Work, Integer> {

    List<Work> findByIsActiveTrueAndBidTrue();

    List<Work> findByIsActiveTrue();
}
