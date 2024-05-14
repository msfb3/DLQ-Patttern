package com.fb.dlqpattern.EAI.domain;

import lombok.Getter;
import lombok.Setter;

public class SendAlteredInfo {

    @Getter
    @Setter

    private int id;
    private String name;
    private int age;
    private String kind;
    private boolean isAltered;


    public SendAlteredInfo(int id, String name, int age, String kind, boolean isAltered) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.kind = kind;
        this.isAltered = isAltered;
    }
}
