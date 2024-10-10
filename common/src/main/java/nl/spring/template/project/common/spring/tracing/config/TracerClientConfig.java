package nl.spring.template.project.common.spring.tracing.config;

import nl.spring.template.project.common.spring.tracing.client.TracerRequestInterceptor;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.context.annotation.Bean;

public abstract class TracerClientConfig {

    @Bean
    public HttpClientBuilder tracerHttpClient() {

        return HttpClients
            .custom()
            .addRequestInterceptorLast(new TracerRequestInterceptor());
    }
}
