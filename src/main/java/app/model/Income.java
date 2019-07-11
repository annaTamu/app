package app.model;


public enum Income {

    ZERO("0"),
    TILL_12000("1-12000"),
    OVER_12000("12001-40000"),
    OVER_40000("40001+");

    private final String value;

    Income(String value) {
        this.value = value;
    }

    public static Income fromValue(String value) {
        for (Income category : values()) {
            if (category.value.equalsIgnoreCase(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException(
            "Unknown enum type " + value + ", Allowed values are " + "[0,1-12000,12001-40000,40001+]");
    }

}
