package app.util;


import app.model.PossibleProducts;

import java.beans.PropertyEditorSupport;

public class PossibleProductsConverter extends PropertyEditorSupport {

    public void setAsText(final String text) throws IllegalArgumentException {
        setValue(PossibleProducts.fromValue(text));


    }

    @Override
    public String getAsText() {
        return super.getAsText();
    }
}
