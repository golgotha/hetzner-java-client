package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record ServerFirewall(long id,
                             FirewallStatus status) {

    public enum FirewallStatus {
        APPLIED("applied"),
        PENDING("pending");

        private final String value;

        FirewallStatus(String value) { this.value = value; }

        @JsonValue
        public String getValue() { return value; }

        @JsonCreator
        public static FirewallStatus fromValue(String value) {
            for (FirewallStatus type : values()) {
                if (type.value.equalsIgnoreCase(value)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown FirewallStatus: " + value);
        }
    }
}
