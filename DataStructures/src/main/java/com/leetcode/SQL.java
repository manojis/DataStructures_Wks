package com.leetcode;

import java.util.*;

public class SQL {
    // HashMap to store the database where each table is identified by its name (String)
    // and each table stores its rows in another HashMap with row ID as the key (Integer)
    // and the row data as a list of Strings
    HashMap<String, HashMap<Integer, List<String>>> db;

    // HashMap to keep track of the next available row ID for each table
    HashMap<String, Integer> idSequence;

    // Constructor to initialize the database with table names and their respective column counts
    public SQL(List<String> names, List<Integer> columns) {
        db = new HashMap<>();
        idSequence = new HashMap<>();

        // Iterate over the list of table names
        for (String tableName : names) {
            // Create a new HashMap to store rows for the current table
            HashMap<Integer, List<String>> rows = new HashMap<>();
            db.put(tableName, rows); // Add the rows map to the main db map under the table name

            // Initialize the row ID sequence for the current table starting from 0
            idSequence.put(tableName, 0);
        }
    }

    // Method to insert a new row into a specified table
    public void insertRow(String name, List<String> row) {
        // Get the rows map for the specified table
        HashMap<Integer, List<String>> rows = db.get(name);

        // Get the next available row ID for the table and increment it
        int rowId = idSequence.get(name) + 1;
        idSequence.put(name, rowId); // Update the row ID sequence

        // Insert the new row into the table with the new row ID as the key
        rows.put(rowId, row);
    }

    // Method to delete a row from a specified table using the row ID
    public void deleteRow(String name, int rowId) {
        // Get the rows map for the specified table
        HashMap<Integer, List<String>> rows = db.get(name);

        // Remove the row with the specified row ID
        rows.remove(rowId);
    }

    // Method to select a specific cell from a table using the table name, row ID, and column ID
    public String selectCell(String name, int rowId, int columnId) {
        // Get the rows map for the specified table
        HashMap<Integer, List<String>> rows = db.get(name);

        // Get the row with the specified row ID
        List<String> row = rows.get(rowId);

        // Return the value from the specified column (columnId-1 because List is 0-based index)
        return row.get(columnId - 1);
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("one", "two", "three");
        List<Integer> columns = Arrays.asList(2, 3, 1);
        List<String> row = Arrays.asList("first", "second", "third");
        List<String> row_1 = Arrays.asList("fourth", "fifth", "sixth");

        SQL obj = new SQL(names, columns);
        obj.insertRow("two", row);
        String param_3 = obj.selectCell("two", 1, 3);
        System.out.println(param_3);
        obj.insertRow("two", row_1);
        obj.deleteRow("two",1);
        param_3 = obj.selectCell("two",2,2);
        System.out.println(param_3);
    }
}