package io.github.golgotha.hetzner.transport;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.http.HttpResponse;

public class JacksonBodyHandler {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static  {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
    }

    public static <W> HttpResponse.BodyHandler<W> ofType(Class<W> targetType) {
        return responseInfo -> {
            HttpResponse.BodySubscriber<InputStream> upstream = HttpResponse.BodySubscribers.ofInputStream();

            return HttpResponse.BodySubscribers.mapping(upstream, inputStream -> {
                try (inputStream) {
                    return objectMapper.readValue(inputStream, targetType);
                } catch (IOException e) {
                    throw new UncheckedIOException("Failed to parse JSON response", e);
                }
            });
        };
    }
}
