package io.github.golgotha.hetzner.api.response.locations;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.golgotha.hetzner.model.server.ListMeta;

import java.util.List;

public record LocationListResponse(
        @JsonProperty("locations") List<Location> locations,
        @JsonProperty("meta") ListMeta meta
) {
}
