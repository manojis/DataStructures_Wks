package com.Misc;

/**
 * Created by Mmanoj.Mohanan Nair on 7/18/2017.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class EmployeeComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        Employee emp1 = (Employee) o1;
        Employee emp2 = (Employee) o2;
        return emp1.id - emp2.id;
    }
}

class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        Employee emp1 = new Employee(3, "Jerome");
        Employee emp2 = new Employee(1, "Albert");
        Employee emp3 = new Employee(2, "Samiya");
        Employee emp4 = new Employee(5, "Stella");
        Employee emp5 = new Employee(4, "Kent");
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);

        Collections.sort(employees, new EmployeeComparator());

        for (Employee employee : employees) {
            System.out.println(employee.id + ", " + employee.name);
        }
    }
}

class Employee {

    public int id;
    public Object name;

    public Employee(int id, Object name) {
        this.id = id;
        this.name = name;
    }
}