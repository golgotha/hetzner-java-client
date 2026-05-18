package io.github.golgotha.hetzner.api.response.metrics;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

public record TimeSeries(@JsonProperty("values")
                         @JsonDeserialize(contentUsing = TimeSeriesPointDeserializer.class) List<TimeSeriesPoint> values) {
}
