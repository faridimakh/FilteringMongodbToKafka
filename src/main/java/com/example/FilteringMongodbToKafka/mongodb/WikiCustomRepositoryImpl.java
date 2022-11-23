package com.example.FilteringMongodbToKafka.mongodb;

import com.example.FilteringMongodbToKafka.model.WikiChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WikiCustomRepositoryImpl implements WikiCustomRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<WikiChange> findWikisByProperties(String type, String user, Boolean bot, Integer namespace, String monid, String domain, Pageable page) {
        final Query query = new Query().with(page);
        query.fields().exclude("_id").exclude("_class");

//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
        final List<Criteria> criteria = new ArrayList<>();
        if (type != null && !type.isEmpty())
            criteria.add(Criteria.where("type").is(type));
        if (monid != null && !monid.isEmpty())
            criteria.add(Criteria.where("user").is(user));
        if (user != null && !user.isEmpty())
            criteria.add(Criteria.where("monid").is(monid));
        if (bot != null && !bot.toString().isEmpty())
            criteria.add(Criteria.where("bot").is(bot));
        if (namespace != null && !namespace.toString().isEmpty())
            criteria.add(Criteria.where("namespace").lte(namespace));
        if (domain != null && !domain.isEmpty())
            criteria.add(Criteria.where("Meta.domain").is(domain));
//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------

        if (!criteria.isEmpty())
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        return mongoTemplate.find(query, WikiChange.class);
    }

}



