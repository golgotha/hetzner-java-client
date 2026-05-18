package io.github.golgotha.hetzner.model.server;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ServerTypePrice(@JsonProperty("location") String location,
                              @JsonProperty("price_hourly") Price priceHourly,
                              @JsonProperty("price_monthly") Price priceMonthly,
                              @JsonProperty("included_traffic") long includedTraffic,
                              @JsonProperty("price_per_tb_traffic") Price pricePerTbTraffic) {
}
