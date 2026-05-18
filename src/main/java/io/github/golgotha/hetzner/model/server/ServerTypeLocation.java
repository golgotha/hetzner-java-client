package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ServerTypeLocation(@JsonProperty("id") long id,
                                 @JsonProperty("name") String name,
                                 @JsonProperty("deprecation") DeprecationInfo deprecation,
                                 @JsonProperty("recommended") boolean recommended,
                                 @JsonProperty("available") boolean available) {
}
