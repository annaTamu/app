package app.model;


public enum Age {
    JUNIOR("0-17"),
    MIDDLE("18-64"),
    SENIOR("65+");

    private final String value;

    Age(String value) {
        this.value = value;
    }

    public static Age fromValue(String value) {
        for (Age category : values()) {
            if (category.value.equalsIgnoreCase(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException(
            "Unknown enum type " + value + ", Allowed values are " + "[0-17, 18-64, 65+]");
    }

}
