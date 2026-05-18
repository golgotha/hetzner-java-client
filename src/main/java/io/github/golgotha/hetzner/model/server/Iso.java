package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public record Iso(@JsonProperty("id") long id,
                  @JsonProperty("name") String name,
                  @JsonProperty("description") String description,
                  @JsonProperty("type") IsoType type,
                  @JsonProperty("deprecation") DeprecationInfo deprecation,
                  @JsonProperty("architecture") Architecture architecture) {

    public enum IsoType {
        PUBLIC("public"),
        PRIVATE("private");

        private final String value;

        IsoType(String value) { this.value = value; }

        @JsonValue
        public String getValue() { return value; }

        @JsonCreator
        public static IsoType fromValue(String value) {
            for (IsoType type : values()) {
                if (type.value.equalsIgnoreCase(value)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown IsoType: " + value);
        }
    }
}
