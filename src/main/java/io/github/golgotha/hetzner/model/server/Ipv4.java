package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Ipv4(@JsonProperty("id") Long id,
                   @JsonProperty("ip") String ip,
                   @JsonProperty("blocked") boolean blocked,
                   @JsonProperty("dns_ptr") String dnsPtr) {
}
