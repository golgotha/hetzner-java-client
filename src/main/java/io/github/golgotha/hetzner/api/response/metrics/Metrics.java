package io.github.golgotha.hetzner.api.response.metrics;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.Map;

public record Metrics(@JsonProperty("start") OffsetDateTime start,
                      @JsonProperty("end") OffsetDateTime end,
                      @JsonProperty("step") double step,
                      @JsonProperty("time_series") Map<String, TimeSeries> timeSeries) {
}
