package com.fb.dlqpattern.ergebnismeldung.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendInfo {
    private int id;
    private String name;
    private int age;
    private String kind;
}
