package io.github.golgotha.hetzner.api.response;

import io.github.golgotha.hetzner.model.server.ListMeta;
import io.github.golgotha.hetzner.model.server.Server;

import java.util.List;

public record ServerListResponse(List<Server> servers,
                                 ListMeta meta) {
}
