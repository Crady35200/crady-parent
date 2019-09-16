package com.crady;

import com.crady.config.ElasticsearchConfig;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class SpringbootEsApplication {

    @Autowired
    private ElasticsearchConfig elasticsearchConfig;
    @Autowired
    private RestHighLevelClient client;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEsApplication.class, args);
    }

    @PostConstruct
    public void init(){
        log.info("init...");
        log.info(elasticsearchConfig.getClusterName() + "," +
                "," + elasticsearchConfig.getHost() + "," + elasticsearchConfig.getPoolSize());
        log.info("client={}",client);
    }

}
