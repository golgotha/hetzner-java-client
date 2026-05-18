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
import java.net.URI;
import java.net.URLEncoder;

public class ServerApi {

    private final HttpTransport httpTransport;
    private final HetznerProperties properties;

    public ServerApi(HetznerProperties properties) {
        this.properties = properties;
        this.httpTransport = new HttpTransport(properties.getTimeout(), properties.getApiToken());
    }

    /**
     * Returns all existing Server objects.
     * @param request Query parameters
     * @return
     */
    public ServerListResponse list(GetServersRequest request) {
        final var url = buildUrl("/servers");
        try {
            return httpTransport.get(url, ServerListResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new HetznerApiException("Unable to fetch servers list", e);
        }
    }

    /**
     * Creates a new Server.
     * @return Returns preliminary information about the Server as well as an Action that covers progress of creation.
     */
    public ServerResponse createServer(CreateServerRequest request) {
        final var url = buildUrl("/servers");
        try {
            return httpTransport.post(url, request, ServerResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new HetznerApiException("Unable to fetch servers list", e);
        }
    }

    /**
     * Returns a specific Server object. The Server must exist inside the Project.
     * @param serverId ID of the Server.
     * @return
     */
    public ServerResponse getServer(int serverId) {
        final var url = buildUrl("/servers/" + serverId);
        try {
            return httpTransport.get(url, ServerResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new HetznerApiException("Unable to fetch servers list", e);
        }
    }

    /**
     * Updates a Server. You can update a Server’s name and a Server’s labels.
     * Please note that Server names must be unique per Project and valid hostnames
     * as per RFC 1123 (i.e. may only contain letters, digits, periods, and dashes).
     */
    public ServerResponse updateServer(int serverId, UpdateServerRequest request) {
        final var url = buildUrl("/servers/" + serverId);
        try {
            return httpTransport.put(url, request, ServerResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new HetznerApiException("Unable to delete server", e);
        }
    }

    public ActionResponse deleteServer(int serverId) {
        final var url = buildUrl("/servers/" + serverId);
        try {
            return httpTransport.delete(url, ActionResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new HetznerApiException("Unable to delete server", e);
        }
    }

    /**
     * Get Metrics for specified Server.
     * You must specify the type of metric to get: cpu, disk or network.
     * You can also specify more than one type by comma separation, e.g. cpu,disk.
     * Depending on the type you will get different time series data
     *
     * @param serverId ID of the Server
     * @param metricType Type of metrics to get (cpu, disk, network)
     * @param start Start of period to get Metrics for (must be in RFC3339 format).
     * @param end End of period to get Metrics for (must be in RFC3339 format).
     * @param step Resolution of results in seconds.
     * @return
     */
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
            throw new HetznerApiException("Unable to fetch servers list", e);
        }
    }

    private String buildUrl(String path) {
        return properties.getHost() + path;
    }
}
