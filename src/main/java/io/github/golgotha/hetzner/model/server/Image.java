package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.OffsetDateTime;
import java.util.Map;

public record Image(@JsonProperty("id") long id,
                    @JsonProperty("type") ImageType type,
                    @JsonProperty("status") ImageStatus status,
                    @JsonProperty("name") String name,
                    @JsonProperty("description") String description,
                    @JsonProperty("image_size") Double imageSize,
                    @JsonProperty("disk_size") double diskSize,
                    @JsonProperty("created") OffsetDateTime created,
                    @JsonProperty("created_from") CreatedFrom createdFrom,
                    @JsonProperty("bound_to") Long boundTo,
                    @JsonProperty("os_flavor") OsFlavor osFlavor,
                    @JsonProperty("os_version") String osVersion,
                    @JsonProperty("rapid_deploy") boolean rapidDeploy,
                    @JsonProperty("protection") Protection protection,
                    @JsonProperty("deprecated") OffsetDateTime deprecated,
                    @JsonProperty("deleted") OffsetDateTime deleted,
                    @JsonProperty("labels") Map<String, String> labels,
                    @JsonProperty("architecture") Architecture architecture) {

    public enum ImageType {
        SYSTEM("system"),
        APP("app"),
        SNAPSHOT("snapshot"),
        BACKUP("backup");

        private final String value;

        ImageType(String value) { this.value = value; }

        @JsonValue
        public String getValue() { return value; }

        @JsonCreator
        public static ImageType fromValue(String value) {
            for (ImageType type : values()) {
                if (type.value.equalsIgnoreCase(value)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown ImageType: " + value);
        }
    }
    public enum ImageStatus {
        AVAILABLE("available"),
        CREATING("creating"),
        UNAVAILABLE("unavailable");

        private final String value;

        ImageStatus(String value) { this.value = value; }

        @JsonValue
        public String getValue() { return value; }

        @JsonCreator
        public static ImageStatus fromValue(String value) {
            for (ImageStatus type : values()) {
                if (type.value.equalsIgnoreCase(value)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown ImageType: " + value);
        }
    }
    public enum OsFlavor {
        UBUNTU("ubuntu"),
        CENTOS("centos"),
        DEBIAN("debian"),
        FEDORA("fedora"),
        ROCKY("rocky"),
        ALMA("alma"),
        OPENSUSE("opensuse"),
        UNKNOWN("unknown");

        private final String value;

        OsFlavor(String value) { this.value = value; }

        @JsonValue
        public String getValue() { return value; }

        @JsonCreator
        public static OsFlavor fromValue(String value) {
            for (OsFlavor type : values()) {
                if (type.value.equalsIgnoreCase(value)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown OsFlavor: " + value);
        }
    }
}
