package io.github.golgotha.hetzner.api.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ActionStatus {
    RUNNING("running"),
    SUCCESS("success"),
    ERROR("error");

    private final String value;

    ActionStatus(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static ActionStatus fromValue(String value) {
        for (ActionStatus status : values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown ActionStatus: " + value);
    }
}
