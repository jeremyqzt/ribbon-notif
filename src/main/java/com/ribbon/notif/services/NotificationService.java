package com.ribbon.notif.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ribbon.notif.config.Environ;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationService {
    private final Environ environment;

    public void sendNotif() {

        String apiKey = environment.getApiKey();
    

        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.elasticemail.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        Mono<String> response = webClient
                .get()
                .uri(builder -> {
                    return builder.path("/v2/email/send")
                            .queryParam("apikey", apiKey)
                            .queryParam("to", "jq357@hotmail.com")
                            .queryParam("template", "recovery")
                            .queryParam("from", "no-reply@ribbonreceipts.com")
                            .build();
                }).retrieve()
                .bodyToMono(String.class);

        log.debug("email sent: {}", response.block());
        return;
    }
}
