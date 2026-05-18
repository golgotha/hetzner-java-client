package io.github.golgotha.hetzner.api.request;

import java.util.Map;

public record UpdateServerRequest(String name,
                                  Map<String, String> labels) {
}
