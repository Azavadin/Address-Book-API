package io.charan.elastic.configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "io.charan.elastic.repository")
public class ElasticConfiguration {

    @Value("${elasticsearch.host}")
    private String EsHost;

    @Value("${elasticsearch.port}")
    private int EsPort;

    @Value("${spring.data.elasticsearch.cluster-name}")
    private String EsClusterName;

    @Bean
    public Client client() {
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
    	TransportClient client = new PreBuiltTransportClient(settings);

        TransportAddress address = null;
		try {
			address = new InetSocketTransportAddress(InetAddress.getByName(EsHost),EsPort);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
        client.addTransportAddress(address);
        return client;        
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }
    
}