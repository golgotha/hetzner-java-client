package io.github.golgotha.hetzner.api;

import io.github.golgotha.hetzner.api.request.GetLocationsRequest;
import io.github.golgotha.hetzner.api.response.locations.LocationListResponse;
import io.github.golgotha.hetzner.api.response.locations.LocationResponse;

public interface LocationApi {
    LocationListResponse list(GetLocationsRequest request);

    LocationResponse getLocation(long locationId);
}
