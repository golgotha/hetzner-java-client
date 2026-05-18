package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DnsPtr(@JsonProperty("ip") String ip,
                     @JsonProperty("dns_ptr") String dnsPtr) {
}
