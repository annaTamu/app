package app.model;

import java.util.Arrays;

public enum PossibleProducts {

    CURRENTACCOUNT("CurrentAccount"),
    CURRENTACCOUNTPLUS("CurrentAccoutPlus"),
    JUNIORSAVERACCOUNT("JuniorSaverAccount"),
    STUDENTACCOUNT("StudentAccount"),
    SENIORACCOUNT("SeniorAccount"),
    DEBITCARD("DebitCard"),
    CREDITCARD("CreditCard"),
    GOLDCREDITCARD("GoldCreditCard");

    private final String value;

    PossibleProducts(String value) {
        this.value = value;
    }

    public static PossibleProducts fromValue(String value) {
        for (PossibleProducts category : values()) {
            if (category.value.equalsIgnoreCase(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException(
            "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }

}
