package io.github.golgotha.hetzner.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ActionError(@JsonProperty("code") String code,
                          @JsonProperty("message") String message) {
}
