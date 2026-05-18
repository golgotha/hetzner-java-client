package io.github.golgotha.hetzner.model.server;

/**
 *
 * @param delete
 * @param rebuild - only for servers
 */
public record Protection(boolean delete,
                         boolean rebuild) {
}
