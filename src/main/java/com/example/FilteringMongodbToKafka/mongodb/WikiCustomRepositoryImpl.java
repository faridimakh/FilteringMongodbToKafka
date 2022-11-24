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

    public List<WikiChange> findWikisByProperties(String type, String title, String user, Boolean bot, Integer namespace, String monid, String domain, Pageable page) {
        final Query query = new Query().with(page);
        query.fields().exclude("_id").exclude("_class");

//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
        final List<Criteria> criteria = new ArrayList<>();
        extracted(type,"type", criteria);
        extracted(title,"title", criteria);
        extracted(user,"user", criteria);
        extracted(monid,"monid", criteria);
        extracted(domain,"Meta.domain", criteria);
        extracted(domain,"Meta.domain", criteria);
        extracted(bot,"bot", criteria);


        if (namespace != null && !namespace.toString().isEmpty())
            criteria.add(Criteria.where("namespace").lte(namespace));

//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------

        if (!criteria.isEmpty())
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
        return mongoTemplate.find(query, WikiChange.class);
    }

    private static void extracted(Object string, String jstring, List<Criteria> criteria) {
        if (string != null )
            criteria.add(Criteria.where(jstring).is(string));
    }

}



