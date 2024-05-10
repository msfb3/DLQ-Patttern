package com.fb.dlqpattern.ergebnismeldung.rest;

import org.springframework.lang.NonNull;

public record SendInfoDTO(@NonNull String wahllokalID, @NonNull String nachricht) {

}
