package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Ipv6(@JsonProperty("id") Long id,
                   @JsonProperty("ip") String ip,
                   @JsonProperty("blocked") boolean blocked,
                   @JsonProperty("dns_ptr") List<DnsPtr> dnsPtr) {
}
