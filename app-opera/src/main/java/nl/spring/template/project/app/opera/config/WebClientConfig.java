package nl.spring.template.project.app.opera.config;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.spring.template.project.app.opera.config.properties.ClientOzonProperties;
import nl.spring.template.project.common.okhttp.HttpClient;
import nl.spring.template.project.common.spring.tracing.config.TracerClientAbstractConfig;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableConfigurationProperties({ClientOzonProperties.class})
public class WebClientConfig extends TracerClientAbstractConfig {

    public interface Ozon {}

    public static Request.Builder GetOzonRequestBuilder(
        final ClientOzonProperties clientOzonProperties,
        final String subPath) {

        return new okhttp3.Request
            .Builder()
            .url(clientOzonProperties.getBaseUrl() + subPath);
    }

    @Bean
    @Autowired
    public HttpClient<Ozon> ozonClient(final OkHttpClient.Builder tracerBuilder) {

        final var connectionPool = new ConnectionPool(5, 5, TimeUnit.MINUTES);
        final var client = tracerBuilder
            .callTimeout(5, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .connectionPool(connectionPool)
            .build();

        return new HttpClient<>(client);

    }

    @Bean
    public JsonFactory createJsonJacksonFactory() {
        return new JsonFactory();
    }

    @Bean
    public ObjectMapper createJsonJacksonObjectMapper(final JsonFactory jsonFactory) {
        return new ObjectMapper(jsonFactory);
    }

}


