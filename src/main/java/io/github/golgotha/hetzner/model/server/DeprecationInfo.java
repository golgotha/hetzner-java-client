package io.github.golgotha.hetzner.model.server;

import java.time.OffsetDateTime;

public record DeprecationInfo(OffsetDateTime unavailableAfter,
                              OffsetDateTime announced) {
}
