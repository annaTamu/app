package app.util;

import app.model.Income;

import java.beans.PropertyEditorSupport;

public class IncomeConverter extends PropertyEditorSupport {
    public void setAsText(final String text) throws IllegalArgumentException {
        setValue(Income.fromValue(text));


    }
}
