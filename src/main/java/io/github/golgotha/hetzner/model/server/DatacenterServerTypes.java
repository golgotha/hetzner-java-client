package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@Deprecated
public record DatacenterServerTypes(
        @JsonProperty("supported")               List<Long> supported,
        @JsonProperty("available")               List<Long> available,
        @JsonProperty("available_for_migration") List<Long> availableForMigration
) {
}
