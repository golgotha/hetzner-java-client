package io.github.golgotha.hetzner.api.request;

public enum SortBy {

    ID("id"),
    ID_ASC("id:asc"),
    ID_DESC("id:desc"),
    NAME("name"),
    NAME_ASC("name:asc"),
    NAME_DESC("name:desc");

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
