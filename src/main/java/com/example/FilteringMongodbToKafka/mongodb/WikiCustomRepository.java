package com.example.FilteringMongodbToKafka.mongodb;

import com.example.FilteringMongodbToKafka.model.WikiChange;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface WikiCustomRepository {
    public List<WikiChange> findWikisByProperties(String type, String title, String user, Boolean bot, Integer namespace, String monid, String wiki, String domain, Pageable page);
}
