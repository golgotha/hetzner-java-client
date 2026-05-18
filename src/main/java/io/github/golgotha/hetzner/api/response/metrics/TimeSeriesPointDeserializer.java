package io.github.golgotha.hetzner.api.response.metrics;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class TimeSeriesPointDeserializer extends StdDeserializer<TimeSeriesPoint> {

    public TimeSeriesPointDeserializer() {
        super(TimeSeriesPoint.class);
    }

    @Override
    public TimeSeriesPoint deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException, JacksonException {
        if (!jsonParser.isExpectedStartArrayToken()) {
            ctx.reportInputMismatch(TimeSeriesPoint.class,
                    "Expected start of array for TimeSeriesPoint, got: " + jsonParser.currentToken());
        }

        jsonParser.nextToken();
        if (jsonParser.currentToken() != JsonToken.VALUE_NUMBER_FLOAT
                && jsonParser.currentToken() != JsonToken.VALUE_NUMBER_INT) {
            ctx.reportInputMismatch(TimeSeriesPoint.class,
                    "Expected number for timestamp, got: " + jsonParser.currentToken());
        }
        double timestamp = jsonParser.getDoubleValue();

        jsonParser.nextToken();
        if (jsonParser.currentToken() != JsonToken.VALUE_STRING) {
            ctx.reportInputMismatch(TimeSeriesPoint.class,
                    "Expected string for value, got: " + jsonParser.currentToken());
        }
        String value = jsonParser.getText();

        jsonParser.nextToken();

        return new TimeSeriesPoint(timestamp, value);
    }
}
