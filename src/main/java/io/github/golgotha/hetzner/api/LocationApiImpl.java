package io.github.golgotha.hetzner.api;

import io.github.golgotha.hetzner.api.request.GetLocationsRequest;
import io.github.golgotha.hetzner.api.response.locations.LocationListResponse;
import io.github.golgotha.hetzner.api.response.locations.LocationResponse;
import io.github.golgotha.hetzner.config.HetznerProperties;
import io.github.golgotha.hetzner.transport.HttpTransport;

import java.io.IOException;

public class LocationApiImpl implements LocationApi {

    private final HttpTransport httpTransport;
    private final HetznerProperties properties;

    public LocationApiImpl(HetznerProperties properties) {
        this.properties = properties;
        this.httpTransport = new HttpTransport(properties.getTimeout(), properties.getApiToken());
    }

    @Override
    public LocationListResponse list(GetLocationsRequest request) {
        var url = buildUrl("/locations");
        if (!request.isEmpty()) {
            url = url + "?" + request.toParameters();
        }

        try {
            return httpTransport.get(url, LocationListResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new HetznerApiException("Unable to fetch locations list", e);
        }
    }

    @Override
    public LocationResponse getLocation(long locationId) {
        final var url = buildUrl("/locations/%s".formatted(locationId));

        try {
            return httpTransport.get(url, LocationResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new HetznerApiException("Unable to fetch locations list", e);
        }
    }

    private String buildUrl(String path) {
        return properties.getHost() + path;
    }
}
