package org.example.model;

import java.util.*;

public class Table {

    private String tableName;
    private Map<Integer,Row> row;

    private LinkedHashMap<String, Column> columns;
    private Integer autoId;

    public Table(String tableName) {
        this.tableName = tableName;
        row = new HashMap<>();
        this.columns = new LinkedHashMap<String, Column>();
        this.autoId = 0;
    }

    // Insert Row
    //Generate unique ID for the to-be-created row. Add the row into the table and return the newly-created-row’s ID.

    public Integer insertRow(LinkedHashMap<String , Object> values){
        Integer id = this.getAutoId();
        Set<String> columnSet = columns.keySet();
        for(String column : columnSet){
            columns.get(column).validate(values.get(column));
        }

        Row newRow = new Row(id, values);
        row.put(id,newRow);
        return id;
    }

    public Column createColumn(String columnName, Type type){
        if(columns.containsKey(columnName)){
            System.out.println("Column already Exist.");
            return null;
        }

        Column newColumn = new Column(type, columnName);
        columns.put(columnName,newColumn);
        return columns.get(columnName);
    }

    public  Integer getAutoId(){
        synchronized (autoId) {
            return this.autoId++;
        }
        //return this.autoId;
    }

    public void printAllValues() {

        for(Map.Entry<Integer,Row> entry : row.entrySet()){
            System.out.println("--- " + entry.getValue().toString());
        }
        return;
    }

    public Integer updateRow(List<Filter> filterList, Object newValue){

        int numberOfRowAffected = 0;

        for(Map.Entry<Integer,Row> entry : row.entrySet()){

            Row iterableRow = entry.getValue();

            for(Map.Entry<String,Object> stringObjectMap : iterableRow.getValues().entrySet()){

                for(Filter filter : filterList) {
                    if (stringObjectMap.getKey().equals(filter.getColumnName()) && stringObjectMap.getValue().equals(filter.getValue())) {
                        iterableRow.getValues().put(filter.getColumnName(), newValue);
                        numberOfRowAffected++;
                    }
                }
            }

        }

        return numberOfRowAffected;

    }

    public Integer deleteRow(String columnName,Object newValue){
        //int numberOfRowAffected = 0;

        Set<Integer> affectedRows = new HashSet<>();

        for(Map.Entry<Integer,Row> entry : row.entrySet()){

            Row iterableRow = entry.getValue();

            for(Map.Entry<String,Object> stringObjectMap : iterableRow.getValues().entrySet()){
                if(stringObjectMap.getKey().equals(columnName) && stringObjectMap.getValue().equals(newValue)){
                    affectedRows.add(entry.getKey());
                }
            }
        }
       for (Integer numberOfRows : affectedRows){
           row.remove(numberOfRows);
       }

        return affectedRows.size();
    }

    public Map<Integer,List<Row>> createIndex(String columnName) {

        Map<Integer, List<Row>> stringListMap = new HashMap<>();

        for(Map.Entry<Integer,Row> entry : row.entrySet()){

            Row iterableRow = entry.getValue();

            for(Map.Entry<String,Object> stringObjectMap : iterableRow.getValues().entrySet()){
                    if (stringObjectMap.getKey().equals(columnName)) {
                        stringListMap.computeIfAbsent(stringObjectMap.getValue().hashCode(), k -> new ArrayList<>()).add(entry.getValue());
                    }

            }

        }

        return stringListMap;

    }
}
