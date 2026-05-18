package io.github.golgotha.hetzner.model.server;

import java.util.List;

@Deprecated
public record DatacenterServerTypes(List<Long> supported,
                                    List<Long> available,
                                    List<Long> availableForMigration) {
}
