package com.fb.dlqpattern.ergebnismeldung.domain;

import lombok.Getter;
import lombok.Setter;

public class SendInfo {
    @Getter
    @Setter
    private int id;
    private String name;
    private int age;
    private String kind;

    public SendInfo( int id, String name, int age, String kind) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.kind = kind;
    }


}
