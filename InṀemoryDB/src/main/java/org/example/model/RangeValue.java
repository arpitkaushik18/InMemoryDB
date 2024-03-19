package org.example.model;

public enum RangeValue {

    STRING_MINVALUE(0),
    STRING_MAXVALUE(20);

     public Integer value;
    RangeValue(int value) {
        this.value = value;
    }
}
