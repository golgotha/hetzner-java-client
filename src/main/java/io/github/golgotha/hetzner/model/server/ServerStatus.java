package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ServerStatus {
    RUNNING("running"),
    INITIALIZING("initializing"),
    STARTING("starting"),
    STOPPING("stopping"),
    OFF("off"),
    DELETING("deleting"),
    MIGRATING("migrating"),
    REBUILDING("rebuilding"),
    UNKNOWN("unknown");

    private final String value;

    ServerStatus(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static ServerStatus fromValue(String value) {
        for (ServerStatus type : values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown ServerStatus: " + value);
    }
}
