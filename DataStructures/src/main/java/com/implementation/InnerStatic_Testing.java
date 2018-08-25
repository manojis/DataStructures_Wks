package com.implementation;

public class InnerStatic_Testing {
    public static String msg ="Testing this method";

    class TestA{

        public void oneMethod(){
            System.out.println("Teting the class A");
            TestC c = new TestC();
            c.display();
        }
    }

    static class TestB{

        public static void main(String args[]){

            InnerStatic_Testing mains = new InnerStatic_Testing();
            TestA a = mains.new TestA();
            a.oneMethod();

            TestB b = new TestB();
            b.secondMethod();
            System.out.println("Message from non-static nested class: "+ msg);
        }

        public void secondMethod(){
            System.out.println("Second Method called");
        }

    }

    public class TestC{

        // Both static and non-static members of Outer class are accessible in
        // this Inner class
        public void display(){
            System.out.println("Message from non-static nested class: "+ msg);
        }
    }
}
