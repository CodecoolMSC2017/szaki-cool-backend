package com.codecool.web.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "author_id")
    private Integer senderId;
    @Column(name = "receiver_id")
    private Integer receiverId;
    private String message;
    @Column(name = "send_date")
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
