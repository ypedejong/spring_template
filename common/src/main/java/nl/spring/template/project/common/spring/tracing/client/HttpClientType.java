package nl.spring.template.project.common.spring.tracing.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.hc.client5.http.classic.HttpClient;

@AllArgsConstructor
@Getter
public class HttpClientType<T> {
    private final HttpClient client;
}
