package nl.spring.template.project.app.opera.client;

import nl.spring.template.project.common.spring.logging.interceptor.OkHttpInterceptor;
import okhttp3.OkHttpClient;

/**
 * Provides a OkHttp3 web client with correlation-id
 */
public class WebClientBuilder {

    private final OkHttpClient okHttpClient;

    public WebClientBuilder(final OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }


    public WebClientBuilder client() {
        return this;
    }

    /**
     * Builds the web client based on give setup.
     *
     * @return OkHttp Client
     */
    public OkHttpClient build() {

        return okHttpClient.newBuilder().addNetworkInterceptor(new OkHttpInterceptor()).build();
    }
}
