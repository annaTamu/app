package app.util;

import app.model.Age;

import java.beans.PropertyEditorSupport;

public class AgeConverter extends PropertyEditorSupport {

    public void setAsText(final String text) throws IllegalArgumentException {
        setValue(Age.fromValue(text));


    }

}
