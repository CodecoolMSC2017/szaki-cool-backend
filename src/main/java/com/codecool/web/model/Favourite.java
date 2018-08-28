package com.codecool.web.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(Favourite.class)
@Table(name = "favourite")
public class Favourite implements Serializable {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Id
    @Column(name = "work_id")
    private Integer workId;

    public Integer getUserId() {
        return userId;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }
}
