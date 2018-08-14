package com.codecool.web.dto;

public class AdvertisementDetailsDto {
    private String workTitle;
    private String workDescription;
    private String currency;
    private Integer price;
    private String garantee_length;
    private Integer garantee_value;
    private String userName;
    private Float userRating;
    private Integer numberOfRatings;
    private Integer userId;

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getGarantee_length() {
        return garantee_length;
    }

    public void setGarantee_length(String garantee_length) {
        this.garantee_length = garantee_length;
    }

    public Integer getGarantee_value() {
        return garantee_value;
    }

    public void setGarantee_value(Integer garantee_value) {
        this.garantee_value = garantee_value;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Float getUserRating() {
        return userRating;
    }

    public void setUserRating(Float userRating) {
        this.userRating = userRating;
    }

    public Integer getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(Integer numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
