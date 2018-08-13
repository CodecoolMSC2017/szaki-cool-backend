package com.codecool.web.service;

import com.codecool.web.date.DateHandler;
import com.codecool.web.dto.StringDto;
import com.codecool.web.model.Work;
import com.codecool.web.repository.UserRepository;
import com.codecool.web.repository.WorkRepository;
import com.codecool.web.service.exceptions.InsufficientDataProvidedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public List<Work> findByCategoryAndUserName(String userName, String category) throws NoSuchElementException{
        List<Work> works = workRepository.findAll();
        int userId = userRepository.findByUsername(userName).get().getId();
        List<Work> result = new ArrayList<>();
        for (Work w: works) {
            if(w.getContractor().getId() == userId && w.getCategory().equals(category)){
                result.add(w);
            }
        }
        return result;
    }

    public List<Work> findAllByUserName(String userName) throws NoSuchElementException {
        int userId = userRepository.findByUsername(userName).get().getId();
        List<Work> works = workRepository.findAll();
        List<Work> result = new ArrayList<>();
        for (Work w : works) {
            if(w.getContractor().getId() == userId){
                result.add(w);
            }
        }
        return result;
    }

    public List<Work> findAllByCategory(String category) throws NoSuchElementException{
        List<Work> works = workRepository.findAll();
        List<Work> result = new ArrayList<>();
        for (Work w: works) {
            if(w.getCategory().equals(category)){
                result.add(w);
            }
        }
        return result;
    }


    public List<StringDto> searchAutofill(String keyword) {
        List<Work> works = getAll();
        String pattern = "(\\b" + keyword + "[^\\s]+)";
        Pattern r = Pattern.compile(pattern);
        List<StringDto> matches = new ArrayList<>();


        for (Work w : works) {
            Matcher m = r.matcher(w.getCategory());
            while (m.find()) {
                matches.add(new StringDto(m.group()));
            }
        }
        return matches;
    }
}
