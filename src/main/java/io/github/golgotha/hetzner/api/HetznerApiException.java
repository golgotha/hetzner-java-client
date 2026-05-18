package io.github.golgotha.hetzner.api;

public class HetznerApiException extends RuntimeException {

    public HetznerApiException(String message) {
        super(message);
    }

    public HetznerApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
