package com.codecool.web.repository;

import com.codecool.web.model.User;
import com.codecool.web.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work, Integer> {

}