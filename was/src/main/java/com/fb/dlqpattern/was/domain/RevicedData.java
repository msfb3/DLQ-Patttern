package com.fb.dlqpattern.was.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevicedData {

    private int id;
    private String name;
    private int age;
    private String kind;
    private boolean isAltered;

}


