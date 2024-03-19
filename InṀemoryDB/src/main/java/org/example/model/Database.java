package org.example.model;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private String currentDatabase;
    private Map<String,Table> tableMap;

    private static Map<String , Database> nameToDB = new HashMap<>();

    private Database(String dbName) {
        this.currentDatabase = dbName;
        this.tableMap = new HashMap<>();
    }

    public static Database getInstance(String dbName){

        if(nameToDB.containsValue(dbName)){
            return nameToDB.get(dbName);
        }

        nameToDB.put(dbName,new Database(dbName));
        return nameToDB.get(dbName);
    }

    public Table createTable(String tableName){
        tableMap.put(tableName,new Table(tableName));
        return tableMap.get(tableName);
    }


}
