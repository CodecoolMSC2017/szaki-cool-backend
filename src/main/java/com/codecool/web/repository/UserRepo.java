package com.codecool.web.repository;


import com.codecool.web.model.UserData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface UserRepo extends CrudRepository <UserData, Long> {
    // using spring data rest dependency
    // Expose the UserData to CRUD api to do the object by creating this interface
    // This is for SELECT, UPDATE etc in database
    // 'Long' is an ID
}
