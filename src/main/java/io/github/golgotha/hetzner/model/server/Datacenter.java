package io.github.golgotha.hetzner.model.server;

// Note: Deprecated by Hetzner after July 1, 2026 — use Location instead
@Deprecated
public record Datacenter(long id,
                         String name,
                         String description,
                         Location location,
                         DatacenterServerTypes serverTypes) {
}
