package com.QueuePrograms;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Created by 212561694 on 4/13/2017.
 */
public class PriorityQueueExample {
    public static void main(String[] args) {

        Queue<Student> studentQueue = new PriorityQueue<Student>(10, marksComparator);
        for (int i = 0; i < studentQueue.size(); i++) {
            Random rand = new Random(10);
            int id = rand.nextInt();
            Random rand1 = new Random(100);
            int marks = rand.nextInt();
            studentQueue.add(new Student("firstname_" + id, "lastname_" + id, id, marks));
            System.out.println(studentQueue.peek().getMarks());
        }
        while (true) {
            Student studs = studentQueue.poll();

            if (studs == null)
                break;
            System.out.println(studs.getMarks());
        }
    }

    public static Comparator<Student> marksComparator = new Comparator<Student>() {
        //@Override
        public int compare(Student s1, Student s2) {

            return (int) (s1.getMarks() - s2.getMarks());
        }
    };
}


/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class EmployeeComparator implements Comparator<Object>
{
    @Override
    public int compare(Object o1, Object o2) {
        Employee emp1 = (Employee)o1;
        Employee emp2 = (Employee)o2;
        return emp1.id-emp2.id;
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
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
 */
