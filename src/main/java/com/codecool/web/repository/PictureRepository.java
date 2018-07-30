package com.codecool.web.repository;

import com.codecool.web.model.Picture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends CrudRepository<Picture, Integer> {

    Picture findByworkIdAndPromotedTrue(Integer workId);
}
