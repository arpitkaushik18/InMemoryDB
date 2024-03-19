package org.example.model;

import org.example.constraint.FieldConstraint;
import org.example.constraint.StringConstraint;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Column {

    Type columnType;
    private String columnName;

    private List<FieldConstraint> fieldValueConstraint;

    public Column(Type columnType, String columnName) {
        this.columnType = columnType;
        this.columnName = columnName;
        this.fieldValueConstraint = new ArrayList<>();
        this.fieldValueConstraint.add(new StringConstraint());
    }

    public boolean validate(Object value){
        for(FieldConstraint fieldConstraint : fieldValueConstraint){
            if(!fieldConstraint.validate(value)){
                return false;
            }
        }
        return true;
    }

    public Type getColumnType() {
        return columnType;
    }

    public void setColumnType(Type columnType) {
        this.columnType = columnType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public List<FieldConstraint> getFieldValueConstraint() {
        return fieldValueConstraint;
    }

    public void setFieldValueConstraint(List<FieldConstraint> fieldValueConstraint) {
        this.fieldValueConstraint = fieldValueConstraint;
    }
}
