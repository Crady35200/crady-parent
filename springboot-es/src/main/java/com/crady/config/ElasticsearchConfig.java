package com.crady.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :Crady
 * date :2019/9/12 16:42
 * desc :
 **/
@Configuration
@Slf4j
@Data
public class ElasticsearchConfig {

    @Value("${elasticsearch.cluster.name}")
    private String clusterName;

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.poolSize}")
    private Integer poolSize;

    @Bean
    public RestHighLevelClient client(){

        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(HttpHost.create(host)));
        return client;
    }


}
