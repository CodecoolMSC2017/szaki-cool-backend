package com.codecool.spring.Main.services;

import com.codecool.spring.Main.dto.UserDto;
import com.codecool.spring.Main.model.UserData;
import com.codecool.spring.Main.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class UserController {

    //create entity object
    @Autowired
    private UserRepo userRepo;


    // map this method to given request url (baseurl/something), sets the method to GET, and the returned mediatype to JSON
    @RequestMapping(path = "/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    //common function
    public List<UserDto> getAllUsers(){
        //returns Iterable type with a preimplemented findAll() method from the repository
        Iterable<UserData> iterable = userRepo.findAll();
        //make a list from the Iterable
        List<UserData> target = new ArrayList<>();
        iterable.forEach(target::add);

        //make list for the dto
        List<UserDto> result = new ArrayList<>();

        //make a dto list (we don't want to how all of the data from the user table
        for(UserData userData: target){
            result.add(makeUserDto(userData));
        }
        return result;
    }

    private UserDto makeUserDto(UserData userData){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userData, UserDto.class);
    }


    @RequestMapping(value="/post", params = {"id", "dog"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody String postMe(@RequestParam("id") Integer id, @RequestParam("dog") Integer dog){
        return Integer.toString(id) + " has " + Integer.toString(dog) + " dogs.";
    }


    public List<Map<String, String>> fetchEverything(String sql, Connection connection) throws SQLException {
        List<Map<String, String>> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(make(resultSet));
                }
            }
            return result;
        }
    }

    private Map<String, String> make(ResultSet resultSet) throws SQLException {
        Map<String, String> result = new HashMap<>();
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnNumber = rsmd.getColumnCount();
        for (int i = 1; i <= columnNumber; ++i) {
            String key = rsmd.getColumnName(i);
            result.put(key, resultSet.getString(key));
        }
        return result;
    }
}
