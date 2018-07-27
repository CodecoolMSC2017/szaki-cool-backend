package com.codecool.web.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    private Date sendDate;


    @ManyToOne
    @JoinColumn(name = "users.user_id")
    private User binding;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public User getBindings() {
        return binding;
    }

    public void setBindings(User binding) {
        this.binding = binding;
    }
}
