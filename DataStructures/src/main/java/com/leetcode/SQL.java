package com.leetcode;

import java.util.*;

public class SQL {

    public SQL(List<String> names, List<Integer> columns) {
        // creating a table with name and an list of string as columsn for each row
        Map<String, List<List<String>>> table = new HashMap<>();
        List<List<String>> row = new ArrayList<>();
        for (int i = 0; i<names.size(); i++) {
            table.putIfAbsent(names.get(i), row);
        }
    }

    public void insertRow(String name, List<String> row) {

    }

    public void deleteRow(String name, int rowId) {

    }

    public String selectCell(String name, int rowId, int columnId) {

        return null;
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