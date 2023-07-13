package com.ribbon.notif.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailDto {
 
    @JsonProperty("apikey")
    private String apikey;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("isTransactional")
    private Boolean isTransactional;

    @JsonProperty("template")
    private String template;
}
