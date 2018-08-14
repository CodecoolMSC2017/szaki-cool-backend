package com.codecool.web.dto;

public class FloatingNumberDto {
    Float number;

    public FloatingNumberDto(Float number) {
        this.number = number;
    }

    public FloatingNumberDto() {
    }

    public Float getNumber() {
        return number;
    }

    public void setNumber(Float number) {
        this.number = number;
    }
}
