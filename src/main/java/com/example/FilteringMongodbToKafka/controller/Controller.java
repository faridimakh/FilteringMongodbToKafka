package com.example.FilteringMongodbToKafka.controller;

import com.example.FilteringMongodbToKafka.kafka.KafkaProducerService;
import com.example.FilteringMongodbToKafka.model.WikiChange;
import com.example.FilteringMongodbToKafka.mongodb.WikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    WikiService wikiService;

    //    @PostMapping
    @RequestMapping("/post")
    public ResponseEntity<List<WikiChange>> addwiki(@RequestBody List<WikiChange> wikilist) {
        return ResponseEntity.ok().body(wikiService.addWiki(wikilist));
    }

    @Autowired
    KafkaProducerService kafkasender;

    @GetMapping("/search")
    public ResponseEntity<List<WikiChange>>  searchPerson(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String user,
            @RequestParam(required = false) Boolean bot,
            @RequestParam(required = false) Integer namespace,
            @RequestParam(required = false) String monid,
            @RequestParam(required = false) String domain,
            @RequestParam Integer page) {
        ResponseEntity<List<WikiChange>> reponse = ResponseEntity.ok().body(wikiService.fetchWikisByProperties(type, title, user, bot, namespace, monid, domain, page));
        List<WikiChange> tokafka = reponse.getBody();
        assert tokafka != null;
        if (tokafka.size() > 0) kafkasender.send(tokafka);
        return reponse;
    }

}
