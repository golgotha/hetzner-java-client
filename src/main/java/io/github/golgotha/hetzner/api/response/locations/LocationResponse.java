package io.github.golgotha.hetzner.api.response.locations;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LocationResponse(
        @JsonProperty("location") Location location) {
}
