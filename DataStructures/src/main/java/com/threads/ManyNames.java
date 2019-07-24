package threads;

public class ManyNames {
    public static void main(String[] args){
        Runnable_code rs = new Runnable_code();
        Thread one  = new Thread(rs);
        one.setName("one");
        Thread second  = new Thread(rs);
        second.setName("second");
        Thread third  = new Thread(rs);
        third.setName("third");

        one.start();;
        second.start();
        third.start();
    }
}
