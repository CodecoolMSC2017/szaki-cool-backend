package com.codecool.web.model;

import javax.persistence.*;

@Entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;
    private String lang;

    public Greeting() {
    }

    public Greeting(Integer id, String lang, String text) {
        this.id = id;
        this.lang = lang;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getText() {
        return text;
    }

    public String getLang() {
        return lang;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
