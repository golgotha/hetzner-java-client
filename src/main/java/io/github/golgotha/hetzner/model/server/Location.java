package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Location(@JsonProperty("id") long id,
                       @JsonProperty("name") String name,
                       @JsonProperty("description") String description,
                       @JsonProperty("country") String country,
                       @JsonProperty("city") String city,
                       @JsonProperty("latitude") double latitude,
                       @JsonProperty("longitude") double longitude,
                       @JsonProperty("network_zone") String networkZone) {
}
