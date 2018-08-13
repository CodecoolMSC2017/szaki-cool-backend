package com.codecool.web.repository;

import com.codecool.web.model.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Integer> {

    @Query(value = "SELECT ROUND(AVG(r.rating),2) FROM Rating r " +
        "JOIN Work w on w.id = r.work " +
        "WHERE w.contractor.id = ?1")
    Float getAvarage(Integer userID);

    @Query(value = "SELECT COUNT(r.rating) FROM Rating r " +
        "JOIN Work w on w.id = r.work " +
        "WHERE w.contractor.id = ?1")
    Integer getNumberOfRatings(Integer userID);
}
