package io.github.golgotha.hetzner.transport;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpTransport implements AutoCloseable {

    private final HttpClient client;
    private final String apiToken;

    public HttpTransport(Duration timeout, String apiToken) {
        this.client = HttpClient.newBuilder()
                .connectTimeout(timeout)
                .build();
        this.apiToken = apiToken;
    }

    public <T> T get(String url, Class<T> responseType) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .setHeader("Authorization", "Bearer " + apiToken)
                .GET()
                .build();

        HttpResponse<T> response = client.send(request, JacksonBodyHandler.ofType(responseType));
        return response.body();
    }

    public <T, B> T post(String url, B body, Class<T> responseType) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .setHeader("Authorization", "Bearer " + apiToken)
                .POST(JacksonBodyPublisher.ofType(body))
                .build();

        HttpResponse<T> response = client.send(request, JacksonBodyHandler.ofType(responseType));
        return response.body();
    }

    public <T, B> T put(String url, B body, Class<T> responseType) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .setHeader("Authorization", "Bearer " + apiToken)
                .PUT(JacksonBodyPublisher.ofType(body))
                .build();

        HttpResponse<T> response = client.send(request, JacksonBodyHandler.ofType(responseType));
        return response.body();
    }

    public <T> T delete(String url, Class<T> responseType) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .setHeader("Authorization", "Bearer " + apiToken)
                .DELETE()
                .build();

        HttpResponse<T> response = client.send(request, JacksonBodyHandler.ofType(responseType));
        return response.body();
    }

    @Override
    public void close() {
        client.close();
    }
}
