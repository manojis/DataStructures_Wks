package com.leetcode;

import org.apache.hadoop.util.hash.Hash;

import java.util.*;

public class SQL {
    private Map<String, List<List<String>>> tables;

    public SQL(List<String> names, List<Integer> columns) {
        // Number of tables that were created based on the size of the names list
        tables = new HashMap<>(names.size());
    }

    public void insertRow(String name, List<String> row) {
        /**
         * The computeIfAbsent() method calculates a value for a new entry based on its key. If an entry with the
         * specified key already exists and its value is not null then the map is not changed.
         * The value is computed using a function, which can be defined by a lambda expression that is
         * compatible with the apply() method of Java's Function interface.
         */
        tables.computeIfAbsent(name, k -> new ArrayList<>()).add(row);
    }

    public void deleteRow(String name, int rowId) {
        List<List<String>> table = tables.get(name);
        // ensure the size of rowId is less than total number of rows in the table(table.size())
        if(rowId > 0 && table.size() > rowId && table.get(rowId-1) != null) {
            table.remove(rowId-1);
        }
    }

    public String selectCell(String name, int rowId, int columnId) {
        List<List<String>> table = tables.get(name);
        String column = "";
        if(rowId > 0 && table != null
                && table.size() > rowId
                && table.get(rowId-1) != null) {
            List<String> row = table.get(rowId-1);
            if (row != null && columnId > 0) {
                column = row.get(columnId);
            }
        }
        return column;
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("one", "two", "three");
        List<Integer> columns = Arrays.asList(2, 3, 1);
        List<String> row = Arrays.asList("first", "second", "third");

        SQL obj = new SQL(names, columns);
        obj.insertRow(names.get(0),row);
        obj.deleteRow(names.get(0),2);
        String param_3 = obj.selectCell(names.get(1),1,2);
        System.out.println(param_3);
    }
}