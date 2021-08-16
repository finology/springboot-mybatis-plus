package gy.finolo.springbootmybatisplus.config.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @description: es配置类, es 6.x
 * @author: Simon
 * @date: 2021-08-05 17:54
 */
@Configuration
//public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {
public class ElasticSearchConfig {

    // Elasticsearch 7.x
//    @Override
//    public RestHighLevelClient elasticsearchClient() {
//        return RestClients.create(ClientConfiguration.builder()
//                .connectedTo("localhost:9200")
//                .build())
//                .rest();
//    }

    // Elasticsearch 6.x
    @Value("${elasticsearch.hosts}")
    private String hosts;

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        String[] hostWithPortArr = hosts.split(",");
        HttpHost[] hosts = Arrays.stream(hostWithPortArr).map(hostPortStr -> {
            String[] hostPorts = hostPortStr.split(":");
            return new HttpHost(hostPorts[0], Integer.valueOf(hostPorts[1]), HttpHost.DEFAULT_SCHEME_NAME);
        }).toArray(HttpHost[]::new);

        return new RestHighLevelClient(RestClient.builder(hosts));
    }
}
