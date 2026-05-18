package io.github.golgotha.hetzner.api.request;

public class GetDatacentersRequest {

    private final String name;
    private final SortBy sortBy;

    private GetDatacentersRequest(Builder builder) {
        this.name = builder.name;
        this.sortBy = builder.sortBy;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public SortBy getSortBy() {
        return sortBy;
    }

    public boolean isEmpty() {
        return name == null && sortBy == null;
    }

    public String toParameters() {
        return String.format("name=%s&sortBy=%s", name, sortBy);
    }

    public static class Builder {
        private String name;
        private SortBy sortBy;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder sortBy(SortBy sortBy) {
            this.sortBy = sortBy;
            return this;
        }

        public GetDatacentersRequest build() {
            return new GetDatacentersRequest(this);
        }
    }
}
