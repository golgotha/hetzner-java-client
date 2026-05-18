package io.github.golgotha.hetzner.api.response.datacenter;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.golgotha.hetzner.model.server.ListMeta;

import java.util.List;

public record DatacenterListResponse(
        @JsonProperty("datacenters") List<Datacenter> datacenters,
        @JsonProperty("recommendation") @Deprecated Long recommendation,
        @JsonProperty("meta") ListMeta meta
) {
}
