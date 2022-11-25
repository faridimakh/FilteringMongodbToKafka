package com.example.FilteringMongodbToKafka.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Revision {
    private Long old;
    private Long revised;

}