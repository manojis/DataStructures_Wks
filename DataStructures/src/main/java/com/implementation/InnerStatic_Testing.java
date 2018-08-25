package com.implementation;

public class InnerStatic_Testing {

    class TestA{

        public void oneMethod(){
            System.out.println("Teting the class A");
        }
    }

    static class TestB{

        public static void main(String args[]){

            InnerStatic_Testing mains = new InnerStatic_Testing();
            TestA a = mains.new TestA();
            a.oneMethod();

            TestB b = new TestB();
            b.secondMethod();
        }

        public void secondMethod(){
            System.out.println("Second Method called");
        }
    }
}
