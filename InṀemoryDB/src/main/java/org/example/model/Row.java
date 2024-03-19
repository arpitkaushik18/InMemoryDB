package org.example.model;

import java.util.LinkedHashMap;

public class Row {

    private Integer rowId;
    private LinkedHashMap<String , Object> values;

    public Row(Integer rowId, LinkedHashMap<String, Object> values) {
        this.rowId = rowId;
        this.values = values;
    }

    public Integer getRowId() {
        return rowId;
    }

    public LinkedHashMap<String, Object> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Row{" +
                "rowId=" + rowId +
                ", values=" + values +
                '}';
    }
}
