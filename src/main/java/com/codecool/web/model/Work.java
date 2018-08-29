package com.codecool.web.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "works")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "notified")
    private Boolean isWinnerNotified;

    @Column(name = "active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "contractor")
    private User contractor;
    private String title;
    private String description;
    private String category;
    private String sharing_date;
    private String due_date;
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "currency.id")
    private Currency currency;
    private Integer guarantee_value;
    @ManyToOne
    @JoinColumn(name = "guarantee_length.id")
    private GuaranteeLength guarantee_length;

    @ElementCollection
    @CollectionTable(
        name = "pictures",
        joinColumns = @JoinColumn(name = "work_id", referencedColumnName = "id")
    )
    @Column(name = "name")
    private List<String> links;

    private String starting_date;
    private Boolean bid;
    private Integer min_bidder_user_rate;
    private String bid_expire_date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    public Integer getId() {
        return id;
    }

    public User getContractor() {
        return contractor;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }


    public Integer getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Integer getGuarantee_value() {
        return guarantee_value;
    }

    public GuaranteeLength getGuarantee_length() {
        return guarantee_length;
    }


    public Boolean getBid() {
        return bid;
    }

    public Integer getMin_bidder_user_rate() {
        return min_bidder_user_rate;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setContractor(User contractor) {
        this.contractor = contractor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setGuarantee_value(Integer guarantee_value) {
        this.guarantee_value = guarantee_value;
    }

    public void setGuarantee_length(GuaranteeLength guarantee_length) {
        this.guarantee_length = guarantee_length;
    }


    public void setBid(Boolean bid) {
        this.bid = bid;
    }

    public void setMin_bidder_user_rate(Integer min_bidder_user_rate) {
        this.min_bidder_user_rate = min_bidder_user_rate;
    }

    public String getSharing_date() {
        return sharing_date;
    }

    public void setSharing_date(String sharing_date) {
        this.sharing_date = sharing_date;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(String starting_date) {
        this.starting_date = starting_date;
    }


    public String getBid_expire_date() {
        return bid_expire_date;
    }

    public void setBid_expire_date(String bid_expire_date) {
        this.bid_expire_date = bid_expire_date;
    }

    public Boolean getWinnerNotified() {
        return isWinnerNotified;
    }

    public void setWinnerNotified(Boolean winnerNotified) {
        isWinnerNotified = winnerNotified;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
