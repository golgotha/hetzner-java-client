package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;

public record ServerType(@JsonProperty("id") long id,
                         @JsonProperty("name") String name,
                         @JsonProperty("description") String description,
                         @JsonProperty("cores") double cores,
                         @JsonProperty("memory") double memory,
                         @JsonProperty("disk") double disk,
                         @JsonProperty("deprecated") boolean deprecated,
                         @JsonProperty("prices") List<ServerTypePrice> prices,
                         @JsonProperty("storage_type") StorageType storageType,
                         @JsonProperty("cpu_type") CpuType cpuType,
                         @JsonProperty("category") String category,
                         @JsonProperty("architecture") Architecture architecture,
                         @JsonProperty("deprecation") DeprecationInfo deprecation,
                         @JsonProperty("locations") List<ServerTypeLocation> locations) {

    public enum StorageType {
        LOCAL("local"),
        NETWORK("network");

        private final String value;

        StorageType(String value) { this.value = value; }

        @JsonValue
        public String getValue() { return value; }

        @JsonCreator
        public static StorageType fromValue(String value) {
            for (StorageType type : values()) {
                if (type.value.equalsIgnoreCase(value)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown StorageType: " + value);
        }
    }

    public enum CpuType {
        SHARED("shared"),
        DEDICATED("dedicated");

        private final String value;

        CpuType(String value) { this.value = value; }

        @JsonValue
        public String getValue() { return value; }

        @JsonCreator
        public static CpuType fromValue(String value) {
            for (CpuType type : values()) {
                if (type.value.equalsIgnoreCase(value)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown CpuType: " + value);
        }
    }
}
