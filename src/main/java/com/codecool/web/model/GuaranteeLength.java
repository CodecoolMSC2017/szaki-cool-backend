package com.codecool.web.model;

import javax.persistence.*;

@Entity
@Table(name = "guarantee_length")
public class GuaranteeLength {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String guarantee_length;

    public Integer getId() {
        return id;
    }

    public String getGuarantee_length() {
        return guarantee_length;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGuarantee_length(String guarantee_length) {
        this.guarantee_length = guarantee_length;
    }
}
