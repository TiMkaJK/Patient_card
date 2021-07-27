package com.pristavka.patient_card.config;

import com.pristavka.patient_card.component.ApplicationProperties;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.pristavka.patient_card.repository.elasticsearch")
@ComponentScan(basePackages = {"com.pristavka.patient_card.service.elasticsearch"})
public class ElasticsearchClientConfig extends AbstractElasticsearchConfiguration {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(this.applicationProperties.getEsHostAndPort())
                .withBasicAuth(this.applicationProperties.getEsUsername(), this.applicationProperties.getEsPassword())
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

    @Bean(name = "elasticsearchRestTemplate")
    public ElasticsearchRestTemplate elasticsearchRestTemplate() {
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }
}

