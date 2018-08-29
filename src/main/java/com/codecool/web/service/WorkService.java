package com.codecool.web.service;

import com.codecool.web.date.DateHandler;
import com.codecool.web.dto.StringDto;
import com.codecool.web.model.Currency;
import com.codecool.web.model.GuaranteeLength;
import com.codecool.web.model.Picture;
import com.codecool.web.model.Work;
import com.codecool.web.repository.*;
import com.codecool.web.service.exceptions.InsufficientDataProvidedException;
import com.codecool.web.service.exceptions.NoCurrencyFoundException;
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

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private GaranteeLenRepository garanteeLenRepository;

    @Autowired
    private PictureRepository pictureRepository;

    public List<Work> getAll() {
        return workRepository.findAll();
    }

    public Work getById(Integer id) {
        return workRepository.findById(id).get();
    }

    public Work addWork(Map<String, String> workMap) throws InsufficientDataProvidedException {
        try {
            Work work = assembleWork(workMap);
            workRepository.save(work);
            pictureRepository.save(makeDefaultPicture(work.getId()));
            return work;
        }
        catch (NoSuchElementException ns){
            throw new NoSuchElementException(ns.getMessage() + " in addWork method after called assembleWork");
        }
    }

    private Picture makeDefaultPicture(Integer workId){
        Picture p = new Picture();
        p.setPromoted(true);
        p.setWorkId(workId);
        p.setName("/workdefault.png");

        return p;
    }


    private GuaranteeLength findGarLenByType(String type) throws NoCurrencyFoundException, InsufficientDataProvidedException {
        if(type.equals("")){
            throw new InsufficientDataProvidedException();
        }
        Iterable<GuaranteeLength> iterable = garanteeLenRepository.findAll();
        List<GuaranteeLength> target = new ArrayList<>();
        iterable.forEach(target::add);
        for (GuaranteeLength g: target) {
            if(g.getGuarantee_length().equals(type)){
                return g;
            }
        }
        throw new NoCurrencyFoundException();

    }

    private Currency findCurrencyIdByType(String type) throws NoCurrencyFoundException, InsufficientDataProvidedException {
        if(type.equals("")){
            throw new InsufficientDataProvidedException();
        }
        Iterable<Currency> iterable = currencyRepository.findAll();
        List<Currency> target = new ArrayList<>();
        iterable.forEach(target::add);
        for (Currency c: target) {
            if(c.getCurrency().equals(type)){
                return c;
            }
        }
        throw new NoCurrencyFoundException();

    }


    private Work assembleWork(Map<String, String> workMap) throws NoSuchElementException, InsufficientDataProvidedException {
        Work work = new Work();

        work.setContractor(userRepository.findById(Integer.parseInt(workMap.get("userId"))).get());
        work.setTitle(workMap.get("workTitle"));
        work.setDescription(workMap.get("workDescription"));
        work.setCategory(workMap.get("category"));
        work.setSharing_date(DateHandler.currentDate());
        work.setDue_date(workMap.get("due_date"));
        work.setPrice(Integer.parseInt(workMap.get("price")));
        work.setCurrency(findCurrencyIdByType(workMap.get("currency")));
        work.setGuarantee_value(Integer.parseInt(workMap.get("guarantee_value")));
        work.setGuarantee_length(findGarLenByType(workMap.get("guarantee_length")));
        //work.setStarting_date(workMap.get("startingDate"));
        //work.setBid(Boolean.parseBoolean(workMap.get("bid")));
        work.setMin_bidder_user_rate(0);                                // hard coded
        //work.setBid_expire_date(workMap.get("bidExpireDate"));

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
