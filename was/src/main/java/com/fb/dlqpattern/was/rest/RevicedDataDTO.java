package com.fb.dlqpattern.was.rest;

import org.springframework.lang.NonNull;

public record RevicedDataDTO(@NonNull int id, @NonNull String name, @NonNull int age, @NonNull String kind, @NonNull boolean isAltered) {
}
