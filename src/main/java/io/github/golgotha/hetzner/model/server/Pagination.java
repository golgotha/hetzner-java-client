package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Pagination(@JsonProperty("page") long page,
                         @JsonProperty("per_page") long perPage,
                         @JsonProperty("previous_page") Long previousPage,
                         @JsonProperty("next_page") Long nextPage,
                         @JsonProperty("last_page") Long lastPage,
                         @JsonProperty("total_entries") Long totalEntries) {
}
