package org.example;


import org.example.model.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
       // System.out.printf("Hello and welcome!");

        Database db = Database.getInstance("test1");

        Table studentTable = db.createTable("student");



        Column studentName = studentTable.createColumn("studentName", Type.STRING);

        Column studentGrade = studentTable.createColumn("studentGrade", Type.STRING);

        Column studentStandard = studentTable.createColumn("studentStandard", Type.STRING);

        LinkedHashMap<String, Object> entryValue = new LinkedHashMap<>();

        entryValue.put(studentName.getColumnName(), "AMAN");
        entryValue.put(studentGrade.getColumnName(), "A");
        entryValue.put(studentStandard.getColumnName(), "1");

        System.out.println(studentTable.insertRow(entryValue));

        LinkedHashMap<String, Object> entryValue1 = new LinkedHashMap<>();

        entryValue1.put(studentName.getColumnName(), "SUMAN");
        entryValue1.put(studentGrade.getColumnName(), "B");
        entryValue1.put(studentStandard.getColumnName(), "2");

        System.out.println(studentTable.insertRow(entryValue1));

        //studentTable.printAllValues();

      // studentTable.updateRow("studentStandard" , "2" , "1");


       // studentTable.deleteRow();

        List<Filter> filterList = new ArrayList<>();

        filterList.add(new Filter("studentStandard" , "2"));
        filterList.add(new Filter("studenName" , "AMAN"));

        //studentTable.updateRow(filterList , "1");
        studentTable.printAllValues();

        //studentTable.deleteRow("studentStandard" , "2");

       // studentTable.printAllValues();


        Map<Integer, List<Row>> integerListMap = studentTable.createIndex("studentStandard");

        System.out.println(integerListMap.toString());
        List<Row> listOfRow = findValueBasedOnIndex(integerListMap, "2");

        System.out.println(listOfRow);
    }

    private static List<Row> findValueBasedOnIndex(Map<Integer, List<Row>> integerListMap, String number) {

           if(integerListMap.containsKey(number.hashCode())){
               return integerListMap.get(number.hashCode());
           }

           return null;
    }

    //  if one column value is exceeding column value
    //  try insert column have null value
    // delete row with some value which does not exist
    // search with null value
    // updating index after insertion or update or deletion
}