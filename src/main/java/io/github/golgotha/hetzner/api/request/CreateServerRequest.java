package io.github.golgotha.hetzner.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class CreateServerRequest {
    @JsonProperty("image")
    private final String image;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("server_type")
    private final String serverType;

    @JsonProperty("automount")
    private final Boolean automount;

    @JsonProperty("datacenter")
    @Deprecated
    private final String datacenter;

    @JsonProperty("firewalls")
    private final List<FirewallRequest> firewalls;

    @JsonProperty("labels")
    private final Map<String, String> labels;

    @JsonProperty("location")
    private final String location;

    @JsonProperty("networks")
    private final List<Long> networks;

    @JsonProperty("placement_group")
    private final Long placementGroup;

    @JsonProperty("public_net")
    private final PublicNetRequest publicNet;

    @JsonProperty("ssh_keys")
    private final List<String> sshKeys;

    @JsonProperty("start_after_create")
    private final Boolean startAfterCreate;

    @JsonProperty("user_data")
    private final String userData;

    @JsonProperty("volumes")
    private final List<Long> volumes;

    private CreateServerRequest(Builder builder) {
        this.image           = builder.image;
        this.name            = builder.name;
        this.serverType      = builder.serverType;
        this.automount       = builder.automount;
        this.datacenter      = builder.datacenter;
        this.firewalls       = builder.firewalls;
        this.labels          = builder.labels;
        this.location        = builder.location;
        this.networks        = builder.networks;
        this.placementGroup  = builder.placementGroup;
        this.publicNet       = builder.publicNet;
        this.sshKeys         = builder.sshKeys;
        this.startAfterCreate = builder.startAfterCreate;
        this.userData        = builder.userData;
        this.volumes         = builder.volumes;
    }

    public static Builder builder(String name, String image, String serverType) {
        return new Builder(name, image, serverType);
    }

    public String getImage()            { return image; }
    public String getName()             { return name; }
    public String getServerType()       { return serverType; }
    public Boolean getAutomount()       { return automount; }
    @Deprecated
    public String getDatacenter()       { return datacenter; }
    public List<FirewallRequest> getFirewalls() { return firewalls; }
    public Map<String, String> getLabels()      { return labels; }
    public String getLocation()         { return location; }
    public List<Long> getNetworks()     { return networks; }
    public Long getPlacementGroup()     { return placementGroup; }
    public PublicNetRequest getPublicNet()      { return publicNet; }
    public List<String> getSshKeys()    { return sshKeys; }
    public Boolean getStartAfterCreate(){ return startAfterCreate; }
    public String getUserData()         { return userData; }
    public List<Long> getVolumes()      { return volumes; }

    public static class Builder {

        // required
        private final String image;
        private final String name;
        private final String serverType;

        // optional
        private Boolean automount;
        private String datacenter;
        private List<FirewallRequest> firewalls;
        private Map<String, String> labels;
        private String location;
        private List<Long> networks;
        private Long placementGroup;
        private PublicNetRequest publicNet;
        private List<String> sshKeys;
        private Boolean startAfterCreate;
        private String userData;
        private List<Long> volumes;

        private Builder(String name, String image, String serverType) {
            if (name == null || name.isBlank())
                throw new IllegalArgumentException("name is required");
            if (image == null || image.isBlank())
                throw new IllegalArgumentException("image is required");
            if (serverType == null || serverType.isBlank())
                throw new IllegalArgumentException("serverType is required");

            this.name       = name;
            this.image      = image;
            this.serverType = serverType;
        }

        public Builder automount(boolean automount) {
            this.automount = automount;
            return this;
        }

        /** @deprecated Use {@link #location(String)} instead. Removed after 1 July 2026. */
        @Deprecated
        public Builder datacenter(String datacenter) {
            if (this.location != null)
                throw new IllegalStateException("Cannot set both datacenter and location");
            this.datacenter = datacenter;
            return this;
        }

        public Builder firewalls(List<FirewallRequest> firewalls) {
            this.firewalls = firewalls;
            return this;
        }

        public Builder labels(Map<String, String> labels) {
            this.labels = labels;
            return this;
        }

        public Builder location(String location) {
            if (this.datacenter != null)
                throw new IllegalStateException("Cannot set both location and datacenter");
            this.location = location;
            return this;
        }

        public Builder networks(List<Long> networks) {
            this.networks = networks;
            return this;
        }

        public Builder placementGroup(long placementGroup) {
            this.placementGroup = placementGroup;
            return this;
        }

        public Builder publicNet(PublicNetRequest publicNet) {
            this.publicNet = publicNet;
            return this;
        }

        public Builder sshKeys(List<String> sshKeys) {
            this.sshKeys = sshKeys;
            return this;
        }

        public Builder startAfterCreate(boolean startAfterCreate) {
            this.startAfterCreate = startAfterCreate;
            return this;
        }

        public Builder userData(String userData) {
            this.userData = userData;
            return this;
        }

        public Builder volumes(List<Long> volumes) {
            this.volumes = volumes;
            return this;
        }

        public CreateServerRequest build() {
            return new CreateServerRequest(this);
        }
    }

    // --- Nested types ---

    public static class FirewallRequest {
        @JsonProperty("firewall")
        private final long firewall;

        public FirewallRequest(long firewall) {
            this.firewall = firewall;
        }

        public long getFirewall() { return firewall; }
    }

    public static class PublicNetRequest {
        @JsonProperty("enable_ipv4")
        private final Boolean enableIpv4;

        @JsonProperty("enable_ipv6")
        private final Boolean enableIpv6;

        @JsonProperty("ipv4")
        private final Long ipv4;

        @JsonProperty("ipv6")
        private final Long ipv6;

        private PublicNetRequest(Builder builder) {
            this.enableIpv4 = builder.enableIpv4;
            this.enableIpv6 = builder.enableIpv6;
            this.ipv4       = builder.ipv4;
            this.ipv6       = builder.ipv6;
        }

        public Boolean getEnableIpv4() { return enableIpv4; }
        public Boolean getEnableIpv6() { return enableIpv6; }
        public Long getIpv4()          { return ipv4; }
        public Long getIpv6()          { return ipv6; }

        public static Builder builder() { return new Builder(); }

        public static class Builder {
            private Boolean enableIpv4;
            private Boolean enableIpv6;
            private Long ipv4;
            private Long ipv6;

            public Builder enableIpv4(boolean enableIpv4) {
                this.enableIpv4 = enableIpv4;
                return this;
            }

            public Builder enableIpv6(boolean enableIpv6) {
                this.enableIpv6 = enableIpv6;
                return this;
            }

            public Builder ipv4(Long ipv4) {
                this.ipv4 = ipv4;
                return this;
            }

            public Builder ipv6(Long ipv6) {
                this.ipv6 = ipv6;
                return this;
            }

            public PublicNetRequest build() {
                return new PublicNetRequest(this);
            }
        }
    }
}
