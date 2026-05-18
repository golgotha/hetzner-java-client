package io.github.golgotha.hetzner.api.response.datacenter;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DatacenterResponse(
        @JsonProperty("datacenter") Datacenter datacenter
) {
}
