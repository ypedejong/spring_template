package nl.spring.template.project.common.okhttp;

import okhttp3.OkHttpClient;

public record HttpClient<T>(OkHttpClient client) {}
