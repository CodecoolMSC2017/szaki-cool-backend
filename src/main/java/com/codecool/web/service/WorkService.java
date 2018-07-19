package com.codecool.web.service;

import com.codecool.web.model.Work;
import com.codecool.web.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkService {

    @Autowired
    private WorkRepository workRepository;

    public List<Work> getAll() {
        return workRepository.findAll();
    }

}
