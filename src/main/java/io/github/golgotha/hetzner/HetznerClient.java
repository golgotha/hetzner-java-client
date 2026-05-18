package io.github.golgotha.hetzner;

import io.github.golgotha.hetzner.api.ServerApi;
import io.github.golgotha.hetzner.config.HetznerProperties;

import java.time.Duration;

public class HetznerClient {

    private final HetznerProperties properties;

    private HetznerClient(HetznerProperties properties) {
        this.properties = properties;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ServerApi servers() {
        return new ServerApi(properties);
    }

    public static class Builder {

        private String apiToken;
        private Duration connectTimeout;

        public Builder apiToken(String apiToken) {
            this.apiToken =  apiToken;
            return this;
        }

        public Builder timeout(Duration timeout) {
            this.connectTimeout = timeout;
            return this;
        }

        public HetznerClient build() {
            if (this.apiToken == null || this.apiToken.isBlank()) {
                throw new IllegalArgumentException("Missing api token");
            }

            return new HetznerClient(new HetznerProperties(apiToken, connectTimeout));
        }
    }
}
