package nl.spring.template.project.common.spring.logging.interceptor;

import nl.spring.template.project.common.spring.tracing.context.TracerContext;
import nl.spring.template.project.common.spring.tracing.context.TracerContextHolder;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class OkHttpInterceptor implements Interceptor {

    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request interceptedRequest = chain.request();

        final var newRequest = interceptedRequest.newBuilder()
                .addHeader("X-Correlation-Id", TracerContextHolder.getContext()
                        .map(TracerContext::correlationId)
                        .orElseThrow(() -> new RuntimeException("Correlation-Id not found")))
                .build();
        return chain.proceed(newRequest);
    }
}