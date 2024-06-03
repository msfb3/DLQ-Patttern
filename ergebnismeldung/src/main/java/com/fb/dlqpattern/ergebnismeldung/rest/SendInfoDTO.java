package com.fb.dlqpattern.ergebnismeldung.rest;

import org.springframework.lang.NonNull;

public record SendInfoDTO(@NonNull int id, @NonNull String name, @NonNull int age, @NonNull String kind) {

}
