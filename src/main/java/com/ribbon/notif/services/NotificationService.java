package com.ribbon.notif.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ribbon.notif.config.Environ;
import com.ribbon.notif.generated.types.EmailType;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationService {
    private final Environ environment;

    public void sendNotif(String toAddress, String remoteToken, EmailType type) {

        WebClient webClient = WebClient.builder()
                .baseUrl(environment.getElasticUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        Mono<String> response = webClient
                .get()
                .uri(builder -> {
                    return builder.path(environment.getElasticPath())
                            .queryParam("apikey", environment.getApiKey())
                            .queryParam("to", toAddress)
                            .queryParam("template", "recovery")
                            .queryParam("from", "no-reply@ribbonreceipts.com")
                            .queryParam("merge_recoveryKey", remoteToken)
                            .queryParam("merge_displayKey", remoteToken)
                            .queryParam("merge_username", toAddress)
                            .build();
                }).retrieve()
                .bodyToMono(String.class);

        log.debug("email sent: {}", response.block());
        return;
    }
}
