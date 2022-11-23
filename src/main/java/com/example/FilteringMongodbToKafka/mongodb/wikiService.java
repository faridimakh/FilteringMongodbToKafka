package com.example.FilteringMongodbToKafka.mongodb;

import com.example.FilteringMongodbToKafka.model.WikiChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class wikiService {

    @Autowired
    private WIkiRepository wIkiRepository;

    public List<WikiChange> addWiki(List<WikiChange> wikilist) {
        return wIkiRepository.insert(wikilist);
    }

    public List<WikiChange> fetchWikisByProperties(String type, String user, Boolean bot, Integer namespace, String monid, String domain, Integer page) {
        return wIkiRepository.findWikisByProperties(type, user, bot, namespace, monid, domain, PageRequest.of(0, 10000));
    }
}

