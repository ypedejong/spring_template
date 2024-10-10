package nl.spring.template.project.app.opera.client;

import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class WebClientBuilderTest {
    @Mock
    WebClientBuilder webClientBuilder;

    @Test
    void test1() {
        final OkHttpClient client = webClientBuilder.client().build();

    }

}