package com.codecool.web.repository;

import com.codecool.web.model.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {

    List<Message> findByreceiverId(Integer id);

    @Query(value = "SELECT m FROM Message m " +
        "WHERE m.senderId = ?1 and m.receiverId = ?2 or m.senderId = ?2 and m.receiverId = ?1" +
        " ORDER BY date")
    List<Message> getMessages(Integer myId, Integer otherId);
}
