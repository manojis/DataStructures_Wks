package com.selectgroup.sql;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.swing.text.html.HTMLDocument;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Manoj.Mohanan Nair
 * @Date 7/31/18
 * Left Outer Join - Returns all the records from the left table/list
 * and the matched records from the right table.
 * Null if there is no match on the right list/table
 *
 * ASSUMPTIONS: id is the primary key for the left and right table
 * else cannot use hashmap, need to use list
 */
public class LeftOuterJoin {
    public static void main(String[] args){
        System.out.println("file path  obtained from args: "+args[0] + " , "+ args[1]);

        String nameFilePath = args[0];
        String payFilePath = args[1];
        String OutputPath = args[2];
        String NEW_LINE_SEPARATOR = "\n";
        String COMMA_DELIMITER = ",";
        String FILE_HEADER = "id,first_name,last_name,salary,bonus";
        FileWriter fileWriter = null;


        HashMap<String,employee_name> empNameMap = new HashMap<>();
        HashMap<String, employee_pay> employeePayMap = new HashMap<>();
        HashMap<String, employee_join> employeeJoinMap = new HashMap<>();

        try {
            Stream<String> nameStream = Files.lines(Paths.get(nameFilePath));
            Stream<String> payStream = Files.lines(Paths.get(payFilePath));
            /**
             * populating the data to the empNameMap and employeePayMap objects
             */
            for(String name:nameStream.skip(1).collect(Collectors.toList())){
                employee_name empName =  new employee_name();
                String [] arrName = name.split(",");
                empName.setFirst_name(arrName[1]);
                empName.setLast_name(arrName[2]);
                empNameMap.put(arrName[0],empName);
            }

            for(String s:payStream.skip(1).collect(Collectors.toList())){
                employee_pay empPay = new employee_pay();
                String [] arrTemp= s.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                empPay.setSalary(arrTemp[1]);
                if(arrTemp.length>2){
                    empPay.setBonus(arrTemp[2]);
                }
                employeePayMap.put(arrTemp[0],empPay);
            }
            /**
             * Here the data can be directly push to a csv file
             * or
             * pushed to hashmap and then pushed to a csv file as implemented below
             */
            empNameMap.forEach((key,employee_name) -> {
                if(null!= employeePayMap.get(key)){
                    employee_join empJoin = new employee_join();
                    empJoin.setFirst_name(employee_name.getFirst_name());
                    empJoin.setLast_name(employee_name.getLast_name());
                    empJoin.setSalary(employeePayMap.get(key).getSalary());
                    empJoin.setBonus(employeePayMap.get(key).getBonus());
                    employeeJoinMap.put(key,empJoin);
                }else{
                    employee_join empJoin = new employee_join();
                    empJoin.setFirst_name(employee_name.getFirst_name());
                    empJoin.setLast_name(employee_name.getLast_name());
                    employeeJoinMap.put(key,empJoin);
                }
            });
            //printing in console before printing to a CSV file
            employeeJoinMap.forEach((key,employee_join) -> System.out.println(
                    key + " " + employee_join.getFirst_name() + " " + employee_join.getLast_name()
                            + " " + employee_join.getSalary() + " " + employee_join.getBonus()));

            fileWriter = new FileWriter(OutputPath);
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);


            for(Map.Entry<String,employee_join> joinEntry : employeeJoinMap.entrySet()){
                fileWriter.append(joinEntry.getKey());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(joinEntry.getValue().getFirst_name());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(joinEntry.getValue().getLast_name());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(joinEntry.getValue().getSalary());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(joinEntry.getValue().getBonus());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("Output CSV file created");
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}