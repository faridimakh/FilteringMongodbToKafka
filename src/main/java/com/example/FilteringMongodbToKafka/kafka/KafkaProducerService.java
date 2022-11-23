package com.example.FilteringMongodbToKafka.kafka;

import com.example.FilteringMongodbToKafka.model.WikiChange;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class KafkaProducerService {
    private static final String TOPIC = "wikichangesresponses";
    @Autowired
    private  KafkaTemplate<String, List<WikiChange>> kafkaTemplate;
    public void send(List<WikiChange> wikilist) {
        log.info("Order object is {}", wikilist);
        log.info("you have just inserted One message containing {} wikis to  kafka topic {}", wikilist.size(),TOPIC);
        kafkaTemplate.send(TOPIC, UUID.randomUUID().toString(), wikilist);
    }
}