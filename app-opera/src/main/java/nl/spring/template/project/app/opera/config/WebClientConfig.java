package nl.spring.template.project.app.opera.config;

import nl.spring.template.project.common.spring.tracing.client.HttpClientType;
import nl.spring.template.project.common.spring.tracing.config.TracerClientConfig;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WebClientConfig extends TracerClientConfig {

    public interface Ozon {}

    @Bean
    @Autowired
    public HttpClientType<Ozon> ozonClient(final HttpClientBuilder tracerBuilder) {

        //TODO: connectionPool, connectionReuse strategy
        //TODO: baseUrl / Domain url

        final var defaultHeaders = List.of(
            new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json"));

        final var client = tracerBuilder
            .setDefaultHeaders(defaultHeaders)
            .build();

        return new HttpClientType<>(client);

    }

}


