package io.github.golgotha.hetzner.api;

import io.github.golgotha.hetzner.api.request.CreateServerRequest;
import io.github.golgotha.hetzner.api.request.GetServersRequest;
import io.github.golgotha.hetzner.api.request.UpdateServerRequest;
import io.github.golgotha.hetzner.api.response.ActionResponse;
import io.github.golgotha.hetzner.api.response.ServerListResponse;
import io.github.golgotha.hetzner.api.response.ServerResponse;
import io.github.golgotha.hetzner.api.response.metrics.MetricType;
import io.github.golgotha.hetzner.api.response.metrics.MetricsResponse;
import io.github.golgotha.hetzner.config.HetznerProperties;
import io.github.golgotha.hetzner.transport.HttpTransport;

import java.io.IOException;
import java.net.URLEncoder;

public class ServerApiImpl implements ServerApi {

    private final HttpTransport httpTransport;
    private final HetznerProperties properties;

    public ServerApiImpl(HetznerProperties properties) {
        this.properties = properties;
        this.httpTransport = new HttpTransport(properties.getTimeout(), properties.getApiToken());
    }

    @Override
    public ServerListResponse list(GetServersRequest request) {
        final var url = buildUrl("/servers");
        try {
            return httpTransport.get(url, ServerListResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new HetznerApiException("Unable to fetch servers list", e);
        }
    }

    @Override
    public ServerResponse createServer(CreateServerRequest request) {
        final var url = buildUrl("/servers");
        try {
            return httpTransport.post(url, request, ServerResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new HetznerApiException("Unable to create a server", e);
        }
    }

    @Override
    public ServerResponse getServer(long serverId) {
        final var url = buildUrl("/servers/" + serverId);
        try {
            return httpTransport.get(url, ServerResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new HetznerApiException("Unable to fetch a server", e);
        }
    }

    @Override
    public ServerResponse updateServer(int serverId, UpdateServerRequest request) {
        final var url = buildUrl("/servers/" + serverId);
        try {
            return httpTransport.put(url, request, ServerResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new HetznerApiException("Unable to update a server", e);
        }
    }

    @Override
    public ActionResponse deleteServer(int serverId) {
        final var url = buildUrl("/servers/" + serverId);
        try {
            return httpTransport.delete(url, ActionResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new HetznerApiException("Unable to delete a server", e);
        }
    }

    @Override
    public MetricsResponse getServerMetrics(int serverId, MetricType metricType, String start, String end, String step) {
        if (metricType == null || start == null || end == null) {
            throw new HetznerApiException("type, start and end are mandatory");
        }

        var type = URLEncoder.encode(metricType.name().toLowerCase());
        var startParam = URLEncoder.encode(start);
        var endParam = URLEncoder.encode(end);
        var url = buildUrl("/servers/%s/metrics?type=%s&start=%s&end=%s".formatted(serverId, type, startParam, endParam));

        if (step != null) {
            url = url + "&step=%s".formatted(step);
        }

        try {
            return httpTransport.get(url, MetricsResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new HetznerApiException("Unable to fetch servers metrics", e);
        }
    }

    private String buildUrl(String path) {
        return properties.getHost() + path;
    }
}
