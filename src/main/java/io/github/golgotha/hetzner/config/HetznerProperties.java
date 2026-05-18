package io.github.golgotha.hetzner.config;

import java.time.Duration;

public class HetznerProperties {
    private final String apiToken;
    private final Duration timeout;
    private final String host = "https://api.hetzner.cloud/v1";

    public HetznerProperties(String apiToken, Duration timeout) {
        this.apiToken = apiToken;
        this.timeout = timeout;
    }

    public String getApiToken() {
        return apiToken;
    }

    public Duration getTimeout() {
        return timeout;
    }

    public String getHost() {
        return host;
    }
}
