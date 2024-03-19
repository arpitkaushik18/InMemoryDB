package org.example.constraint;

import org.example.model.RangeValue;

import static org.example.model.RangeValue.STRING_MAXVALUE;
import static org.example.model.RangeValue.STRING_MINVALUE;

public class StringConstraint implements FieldConstraint{
    @Override
    public boolean validate(Object object) {
        return object.getClass().equals(String.class) && object.toString().length() > STRING_MINVALUE.value && object.toString().length() <= STRING_MAXVALUE.value;
    }
}
