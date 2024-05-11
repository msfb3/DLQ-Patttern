package com.fb.dlqpattern.ergebnismeldung.domain;

public class SendInfo {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
