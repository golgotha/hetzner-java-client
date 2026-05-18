package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PrivateNet(@JsonProperty("network") long network,
                         @JsonProperty("ip") String ip,
                         @JsonProperty("alias_ips") List<String> aliasIps,
                         @JsonProperty("mac_address") String macAddress) {
}
