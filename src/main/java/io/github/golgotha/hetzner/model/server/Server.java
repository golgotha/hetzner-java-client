package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public record Server(@JsonProperty("id") long id,
                     @JsonProperty("name") String name,
                     @JsonProperty("status") ServerStatus status,
                     @JsonProperty("created") OffsetDateTime created,
                     @JsonProperty("public_net") PublicNet publicNet,
                     @JsonProperty("private_net") List<PrivateNet> privateNet,
                     @JsonProperty("server_type") ServerType serverType,
                     @JsonProperty("location") Location location,
                     @JsonProperty("datacenter") Datacenter datacenter,
                     @JsonProperty("image") Image image,
                     @JsonProperty("iso") Iso iso,
                     @JsonProperty("rescue_enabled") boolean rescueEnabled,
                     @JsonProperty("locked") boolean locked,
                     @JsonProperty("backup_window") String backupWindow,
                     @JsonProperty("outgoing_traffic") Long outgoingTraffic,
                     @JsonProperty("ingoing_traffic") Long ingoingTraffic,
                     @JsonProperty("included_traffic") Long includedTraffic,
                     @JsonProperty("protection") Protection protection,
                     @JsonProperty("labels") Map<String, String> labels,
                     @JsonProperty("volumes") List<Long> volumes,
                     @JsonProperty("load_balancers")  List<Long> loadBalancers,
                     @JsonProperty("primary_disk_size") double primaryDiskSize,
                     @JsonProperty("placement_group") PlacementGroup placementGroup) {
}
