package com.selectgroup;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Manoj.Mohanan Nair
 * @Date 7/31/18
 * Left Outer Join - Returns all the records from the left table/list
 * and the matched records from the right table.
 * Null if there is no match on the right list/table
 * Assumption: Order of the results is not important else will use TreeMap instead of HashMap
 */
public class LeftOuterJoin {

    public static void main(String[] args){
        HashMap<String,employee_name> empNameMap = new HashMap<>();
        HashMap<String, employee_pay> employeePayMap = new HashMap<>();


        String nameFilePath = "/Users/mohitha/Downloads/Misc/employee_names.csv";
        String payFilePath = "/Users/mohitha/Downloads/Misc/employee_pay.csv";

        try {
            Stream<String> nameStream = Files.lines(Paths.get(nameFilePath));
            Stream<String> payStream = Files.lines(Paths.get(payFilePath));
            /**
             * populating the data to the objects using java 8 streams as well as before
             * as i am not sure if the restriction is only limited to joining data
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

            empNameMap.forEach((key,employee_name) -> System.out.println(
                    key + " " + employee_name.getFirst_name() + " " + employee_name.getLast_name()));
            employeePayMap.forEach((key,employee_pay) -> System.out.println(
                    key + " " + employee_pay.getSalary() + " " + employee_pay.getBonus()));

            empNameMap.forEach((key,employee_name) -> {

                if(null!= employeePayMap.get(key)){

                }else{

                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
