package io.github.golgotha.hetzner.api;

import io.github.golgotha.hetzner.api.request.CreateServerRequest;
import io.github.golgotha.hetzner.api.request.GetServersRequest;
import io.github.golgotha.hetzner.api.request.UpdateServerRequest;
import io.github.golgotha.hetzner.api.response.ActionResponse;
import io.github.golgotha.hetzner.api.response.ServerListResponse;
import io.github.golgotha.hetzner.api.response.ServerResponse;
import io.github.golgotha.hetzner.api.response.metrics.MetricType;
import io.github.golgotha.hetzner.api.response.metrics.MetricsResponse;

public interface ServerApi {

    /**
     * Returns all existing Server objects.
     * @param request Query parameters
     * @return
     */
    ServerListResponse list(GetServersRequest request);

    /**
     * Creates a new Server.
     * @return Returns preliminary information about the Server as well as an Action that covers progress of creation.
     */
    ServerResponse createServer(CreateServerRequest request);

    /**
     * Returns a specific Server object. The Server must exist inside the Project.
     * @param serverId ID of the Server.
     * @return
     */
    ServerResponse getServer(long serverId);

    /**
     * Updates a Server. You can update a Server’s name and a Server’s labels.
     * Please note that Server names must be unique per Project and valid hostnames
     * as per RFC 1123 (i.e. may only contain letters, digits, periods, and dashes).
     */
    ServerResponse updateServer(int serverId, UpdateServerRequest request);

    ActionResponse deleteServer(int serverId);

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
    MetricsResponse getServerMetrics(int serverId, MetricType metricType, String start, String end, String step);
}
