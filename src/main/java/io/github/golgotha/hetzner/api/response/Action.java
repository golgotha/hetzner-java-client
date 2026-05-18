package io.github.golgotha.hetzner.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;

public record Action(@JsonProperty("id") long id,
                     @JsonProperty("command") String command,
                     @JsonProperty("status") ActionStatus status,
                     @JsonProperty("started") OffsetDateTime started,
                     @JsonProperty("finished") OffsetDateTime finished,
                     @JsonProperty("progress") int progress,
                     @JsonProperty("resources") List<ActionResource> resources,
                     @JsonProperty("error") ActionError error) {

    public boolean isSuccess() { return status == ActionStatus.SUCCESS; }
    public boolean isRunning() { return status == ActionStatus.RUNNING; }
    public boolean isError()   { return status == ActionStatus.ERROR; }
}
