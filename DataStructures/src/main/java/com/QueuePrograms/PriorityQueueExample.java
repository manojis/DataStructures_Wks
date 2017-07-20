package com.QueuePrograms;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Manoj.Mohanan Nair on 4/13/2017.
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