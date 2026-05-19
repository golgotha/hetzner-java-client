package io.github.golgotha.hetzner.api;

import io.github.golgotha.hetzner.api.request.GetDatacentersRequest;
import io.github.golgotha.hetzner.api.response.datacenter.DatacenterListResponse;
import io.github.golgotha.hetzner.api.response.datacenter.DatacenterResponse;

public interface DatacenterApi {

    /**
     * Returns all Data Centers.
     * @param request
     * @return
     */
    DatacenterListResponse list(GetDatacentersRequest request);

    /**
     *
     * @param id ID of a datacenter
     * @return Returns a single Data Center.
     */
    DatacenterResponse getDatacenter(long id);
}
