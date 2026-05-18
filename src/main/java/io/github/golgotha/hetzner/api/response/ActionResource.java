package io.github.golgotha.hetzner.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ActionResource(@JsonProperty("id") long id,
                             @JsonProperty("type") String type) {
}
