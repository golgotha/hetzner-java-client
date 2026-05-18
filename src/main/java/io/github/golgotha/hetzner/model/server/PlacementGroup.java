package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public record PlacementGroup(@JsonProperty("id") long id,
                             @JsonProperty("name") String name,
                             @JsonProperty("labels") Map<String, String> labels,
                             @JsonProperty("type") PlacementGroupType type,
                             @JsonProperty("created") OffsetDateTime created,
                             @JsonProperty("servers") List<Long> servers) {

    public enum PlacementGroupType {
        SPREAD("spread");

        private final String value;

        PlacementGroupType(String value) { this.value = value; }

        @JsonValue
        public String getValue() { return value; }

        @JsonCreator
        public static PlacementGroupType fromValue(String value) {
            for (PlacementGroupType type : values()) {
                if (type.value.equalsIgnoreCase(value)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown PlacementGroupType: " + value);
        }
    }
}
