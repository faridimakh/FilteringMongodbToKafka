package com.example.FilteringMongodbToKafka.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Builder
@Document(collection = "wikiChange")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WikiChange {
    private String monid;
    private String type;
    private Integer namespace;
    private String title;
    private String comment;
    private Long timestamp;
    private String user;
    private Boolean bot;
    private Boolean minor;
    private String server_url;
    private String server_name;
    private String server_script_path;
    private Boolean patrolled;
    private String serverUrl;
    private String serverName;
    private String serverScriptPath;
    private String wiki;
    private String parsedcomment;
    private Revision revision;
    private Length length;
    private Meta meta;



}
