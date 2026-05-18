package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PublicNet(@JsonProperty("ipv4") Ipv4 ipv4,
                        @JsonProperty("ipv6") Ipv6 ipv6,
                        @JsonProperty("floating_ips") List<Long> floatingIps,
                        @JsonProperty("firewalls") List<ServerFirewall> firewalls) {
}
