package com.example.ExamModel.dto;

import javax.validation.constraints.NotNull;

public class ManagerDto {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ManagerDto(int id) {
        this.id = id;
    }

    @NotNull(message = "not null")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ManagerDto(String name) {
        this.name = name;
    }
}
