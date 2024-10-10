package nl.spring.template.project.common.spring.tracing.client;

import nl.spring.template.project.common.spring.tracing.context.TracerContext;
import nl.spring.template.project.common.spring.tracing.context.TracerContextHolder;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.http.protocol.HttpContext;

import java.io.IOException;

import static nl.spring.template.project.common.spring.tracing.filter.TracerPropagateFilter.X_CORRELATION_ID;

public class TracerRequestInterceptor implements HttpRequestInterceptor {

    @Override
    public void process(
        final HttpRequest request,
        final EntityDetails entity,
        final HttpContext context) throws HttpException, IOException {

        final var correlationId = TracerContextHolder.getContext()
            .map(TracerContext::correlationId)
            .orElseThrow(() -> new RuntimeException("Could find correlationId in TracerContextHolder"));

        request.setHeader(X_CORRELATION_ID, correlationId);

    }
}
