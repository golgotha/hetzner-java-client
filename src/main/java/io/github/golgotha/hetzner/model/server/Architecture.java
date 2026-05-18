package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Architecture {
    X86("x86"),
    ARM("arm");

    private final String value;

    Architecture(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static Architecture fromValue(String value) {
        for (Architecture type : values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown Architecture: " + value);
    }
}
