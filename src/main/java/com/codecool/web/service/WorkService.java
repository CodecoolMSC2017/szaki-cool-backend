package com.codecool.web.service;

import com.codecool.web.date.DateHandler;
import com.codecool.web.model.Work;
import com.codecool.web.repository.UserRepository;
import com.codecool.web.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class WorkService {

    @Autowired
    private WorkRepository workRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Work> getAll() {
        return workRepository.findAll();
    }

    public Work getById(Integer id) {
        return workRepository.findById(id).get();
    }

    public Work addWork(Map<String, String> workMap){

        try {
            Work work = assembleWork(workMap);
            workRepository.save(work);

            return work;
        }
        catch (NoSuchElementException ns){
            throw new NoSuchElementException(ns.getMessage() + " in addWork method after called assembleWork");
        }
    }

    //not tested
    private Work assembleWork(Map<String, String> workMap) throws NoSuchElementException {
        Work work = new Work();

        work.setContractor(userRepository.findById(Integer.parseInt(workMap.get("userId"))).get());
        work.setTitle(workMap.get("title"));
        work.setDescription(workMap.get("description"));
        work.setCategory(workMap.get("category"));
        work.setSharing_date(DateHandler.currentDate());
        work.setDue_date(workMap.get("dueDate"));
        work.setPrice(Integer.parseInt(workMap.get("price")));

        return work;
    }

}
