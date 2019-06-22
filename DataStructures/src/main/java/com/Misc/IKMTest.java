package com.Misc;

/**
 * @author Manoj.Mohanan Nair
 * @Date 10/20/18
 */
public class IKMTest extends Sub{

    @Override
    public String value() {
        return "IKMTest";
    }
    public static void main(String[] args) {
        IKMTest testClass = new IKMTest();
        boolean b = false;
        char i = 't';
        if (testClass instanceof IKMType) {
            System.out.println((b = false) ? ((Super) testClass).value() : b);
        } else {
            System.out.println((b = true) ? ((Sub) testClass).value() : i);
        }
    }
}
interface IKMType {
    String value();
}
class Super implements IKMType {
    @Override
    public String value() {
        return "Super";
    }
}
class Sub extends Super {
    @Override
    public String value() {
        return "Sub";
    }
}
