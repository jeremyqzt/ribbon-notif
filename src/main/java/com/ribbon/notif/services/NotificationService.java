package com.ribbon.notif.services;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ribbon.notif.config.Environ;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotificationService {
    private final Environ environment;
    
    public void sendNotif() {

        String apiKey = environment.getApiKey();
        System.out.println(apiKey);
        System.out.println(apiKey);
        System.out.println(apiKey);

        WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:3000")
            .defaultCookie("cookie-name", "cookie-value")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

        return;
    }
}
