package com.example.FilteringMongodbToKafka.mongodb;

import com.example.FilteringMongodbToKafka.model.WikiChange;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WIkiRepository extends MongoRepository<WikiChange, String>, WikiCustomRepository {

}
