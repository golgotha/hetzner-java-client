package io.github.golgotha.hetzner.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ActionResponse(@JsonProperty("action") Action action) {
}
