package io.github.golgotha.hetzner.api.request;

import io.github.golgotha.hetzner.model.server.ServerStatus;

import java.util.List;

public class GetServersRequest {

    private final String name;
    private final String labelSelector;
    private final SortBy sort;
    private final List<ServerStatus> status;
    private final Integer page;
    private final Integer perPage;

    private GetServersRequest(Builder builder) {
        this.name = builder.name;
        this.labelSelector = builder.labelSelector;
        this.sort = builder.sort;
        this.status = builder.status;
        this.page = builder.page;
        this.perPage = builder.perPage;
    }

    public static GetServersRequest empty() {
        return new GetServersRequest(builder());
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getLabelSelector() {
        return labelSelector;
    }

    public SortBy getSort() {
        return sort;
    }

    public List<ServerStatus> getStatus() {
        return status;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public static class Builder {
        private String name;
        private String labelSelector;
        private SortBy sort;
        private List<ServerStatus> status;
        private Integer page;
        private Integer perPage;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder labelSelector(String labelSelector) {
            this.labelSelector = labelSelector;
            return this;
        }

        public Builder sort(SortBy sort) {
            this.sort = sort;
            return this;
        }

        public Builder status(List<ServerStatus> status) {
            this.status = status;
            return this;
        }

        public Builder page(Integer page) {
            this.page = page;
            return this;
        }

        public Builder perPage(Integer perPage) {
            this.perPage = perPage;
            return this;
        }

        public GetServersRequest build() {
            return new GetServersRequest(this);
        }
    }

    public enum SortBy {
        ID("id"),
        ID_ASC("id:asc"),
        ID_DESC("id:desc"),
        NAME("name"),
        NAME_ASC("name:asc"),
        NAME_DESC("name:desc"),
        CREATED("created"),
        CREATED_ASC("created:asc"),
        CREATED_DESC("created:desc");

        private final String value;

        SortBy(String value) { this.value = value; }

        public String getValue() { return value; }

        public static SortBy fromValue(String value) {
            for (SortBy type : values()) {
                if (type.value.equalsIgnoreCase(value)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown ServerStatus: " + value);
        }
    }
}
