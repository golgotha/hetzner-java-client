package io.github.golgotha.hetzner.api;

import io.github.golgotha.hetzner.api.request.GetDatacentersRequest;
import io.github.golgotha.hetzner.api.request.GetLocationsRequest;
import io.github.golgotha.hetzner.api.response.datacenter.DatacenterListResponse;
import io.github.golgotha.hetzner.api.response.datacenter.DatacenterResponse;
import io.github.golgotha.hetzner.api.response.locations.LocationListResponse;
import io.github.golgotha.hetzner.api.response.locations.LocationResponse;
import io.github.golgotha.hetzner.config.HetznerProperties;
import io.github.golgotha.hetzner.transport.HttpTransport;

import java.io.IOException;

public class DatacenterApi {

    private final HttpTransport httpTransport;
    private final HetznerProperties properties;

    public DatacenterApi(HetznerProperties properties) {
        this.properties = properties;
        this.httpTransport = new HttpTransport(properties.getTimeout(), properties.getApiToken());
    }

    /**
     * Returns all Data Centers.
     * @param request
     * @return
     */
    public DatacenterListResponse list(GetDatacentersRequest request) {
        var url = buildUrl("/datacenters");
        if (!request.isEmpty()) {
            url = url + "?" + request.toParameters();
        }

        try {
            return httpTransport.get(url, DatacenterListResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new HetznerApiException("Unable to fetch locations list", e);
        }
    }

    /**
     *
     * @param id ID of a datacenter
     * @return Returns a single Data Center.
     */
    public DatacenterResponse getDatacenter(long id) {
        final var url = buildUrl("/datacenters/%s".formatted(id));

        try {
            return httpTransport.get(url, DatacenterResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new HetznerApiException("Unable to fetch locations list", e);
        }
    }

    private String buildUrl(String path) {
        return properties.getHost() + path;
    }
}
