package io.github.golgotha.hetzner.api.response.metrics;

public record TimeSeriesPoint(double timestamp, String value) {

    public double getValueAsDouble() {
        return Double.parseDouble(value);
    }
}
