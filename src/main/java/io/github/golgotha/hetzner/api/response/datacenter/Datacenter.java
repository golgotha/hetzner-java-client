package io.github.golgotha.hetzner.api.response.datacenter;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.golgotha.hetzner.api.response.locations.Location;
import io.github.golgotha.hetzner.model.server.DatacenterServerTypes;

public record Datacenter(
        @JsonProperty("id")           long id,
        @JsonProperty("name")         String name,
        @JsonProperty("description")  String description,
        @JsonProperty("location")     Location location,
        @JsonProperty("server_types") @Deprecated DatacenterServerTypes serverTypes
) {
}
