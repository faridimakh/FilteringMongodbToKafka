package com.example.FilteringMongodbToKafka.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Meta {
    private String metatid;
    private String uri;
    private String request_id;
    private String dt;
    private String domain;
    private String stream;
    private String topic;
    private Integer partition;
    private Offset offset;

}
