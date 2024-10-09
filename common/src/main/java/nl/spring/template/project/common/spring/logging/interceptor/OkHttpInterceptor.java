package nl.spring.template.project.common.spring.logging.interceptor;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

@Slf4j
public class AddTracingHttpInterceptor implements Interceptor {

    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        log.info("Intercepted headers: {} from URL: {}", request.headers(), request.url());
        return chain.proceed(request);
    }
}