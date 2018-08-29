package com.codecool.web.model;

import javax.persistence.*;

@Entity
@Table(name = "guarantee_length")
public class GuaranteeLength {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String guaranteeLength;

    public Integer getId() {
        return id;
    }

    public String getGuaranteeLength() {
        return guaranteeLength;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGuaranteeLength(String guarantee_length) {
        this.guaranteeLength = guarantee_length;
    }
}
