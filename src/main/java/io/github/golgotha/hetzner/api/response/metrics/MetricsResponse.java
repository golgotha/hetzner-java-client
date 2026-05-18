package io.github.golgotha.hetzner.api.response.metrics;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MetricsResponse(@JsonProperty("metrics") Metrics metrics) {
}
