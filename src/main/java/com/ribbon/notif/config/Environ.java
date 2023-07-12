package com.ribbon.notif.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;


@Component
@Getter
public class Environ {
    @Value("${API_KEY}")
    private String apiKey;
}

