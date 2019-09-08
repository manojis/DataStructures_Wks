package leetcode;

/**
 * @author Manoj.Mohanan Nair
 * @Date 9/7/19
 */
public class MovingAverageStream {

    private int[] arr;
    int index, n;
    private int sum;

    public MovingAverageStream(int size) {
        arr = new int[size];
        index = 0;
        sum = 0;
    }
    public double next(int val){
        if(n < arr.length){
            n++;
        }
        sum = sum - arr[index];
        sum = sum + val;
        arr[index] = val;
        index = (index + 1)%(arr.length);
        return (double)sum/n;
    }
    public static void main(String[] args){
        double avg = 0;
        MovingAverageStream obj1 = new MovingAverageStream(3);
        avg=obj1.next(3);
        System.out.println(avg);
        avg=obj1.next(6);
        System.out.println(avg);
        avg=obj1.next(4);
        System.out.println(avg);
        avg=obj1.next(7);
        System.out.println(avg);
        avg=obj1.next(11);
        System.out.println(avg);
        avg=obj1.next(12);
        System.out.println(avg);
        avg=obj1.next(13);
        System.out.println(avg);
    }
}
