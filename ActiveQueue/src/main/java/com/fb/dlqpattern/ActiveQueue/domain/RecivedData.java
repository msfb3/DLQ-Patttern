package com.fb.dlqpattern.ActiveQueue.domain;

import lombok.Data;

@Data
public class RecivedData {

    private int id;
    private String name;
    private int age;
    private String kind;
    private boolean isAltered;


    public RecivedData(int id, String name, int age, String kind, boolean isAltered) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.kind = kind;
        this.isAltered = isAltered;
    }
}
