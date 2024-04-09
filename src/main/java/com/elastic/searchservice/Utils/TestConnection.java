package com.elastic.searchservice.Utils;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.EscapedErrors;


public class TestConnection {
    private static final Logger log= LoggerFactory.getLogger(TestConnection.class);
    @Value("${serverUrl}")
    private String serverUrl;
    @Value("${apiKey}")
    private String apiKey;
    public String getResponse(){
        String response=null;
        try {
            ElasticsearchClient esClient = ElasticClient.getElasticClient(serverUrl,apiKey);
            response= String.valueOf(esClient.count().count());

        }
        catch (Exception e){
            log.error("Exception in TestConnection -> getResponse(): {}",e);
        }
        return response;
    }

}
