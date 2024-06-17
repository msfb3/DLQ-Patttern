package com.fb.dlqpattern.EAI.rest;

import org.springframework.lang.NonNull;


    public record ReceivedInfoDTO(@NonNull int id, @NonNull String name, @NonNull int age, @NonNull String kind, @NonNull boolean isAltered) {

    }

