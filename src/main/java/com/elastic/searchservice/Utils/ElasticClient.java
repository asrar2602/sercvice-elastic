package com.elastic.searchservice.Utils;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElasticClient {
    private static final Logger log= LoggerFactory.getLogger(ElasticClient.class);

    public static ElasticsearchClient getElasticClient(String serverUrl, String apiKey){
        ElasticsearchTransport transport = null;
        try {
            RestClient restClient = RestClient
                    .builder(HttpHost.create(serverUrl))
                    .setDefaultHeaders(new Header[]{
                            new BasicHeader("Authorization", "ApiKey " + apiKey)
                    })
                    .build();

            // Create the transport with a Jackson mapper
            transport = new RestClientTransport(
                    restClient, new JacksonJsonpMapper());

        }
        catch (Exception e){
            log.error("Exception in ElasticClient -> getElasticClient(): {}",e);
        }
        return new ElasticsearchClient(transport);
    }

}
