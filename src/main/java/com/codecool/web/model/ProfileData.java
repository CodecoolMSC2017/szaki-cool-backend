package com.codecool.web.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "profiles")
public class ProfileData {

    @NotNull
    @NotEmpty
    @Id
    @Column(name = "profiles.user_id")
    private long user_id;

    @Nullable
    @Column(name = "profiles.first_name")
    private String first_name;

    @Nullable
    @Column(name = "profiles.last_name")
    private String last_name;


    @Nullable

    private String phone;

    @Nullable
    private String address;

    @Nullable
    private String picture;

    @Nullable
    private String description;



    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
