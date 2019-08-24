package com.Java_Experimentation.threads;

/**
 * @author Manoj.Mohanan Nair
 * @Date 8/23/19
 */
public class TestShow {
    public static void main(String[] args){
        TestShow testThreads = new TestShow();
        testThreads.go();
    }

    public void go(){
        // create Thread 1, which will try to book seats 1A and 1B
        Thread getSeats1 = new Thread(() -> {
            ticketAgentBooks("1A");
            ticketAgentBooks("1B");
        });
        // create Thread 2, which will try to book seats 1A and 1B
        Thread getSeats2 = new Thread(() -> {
            ticketAgentBooks("1A");
            ticketAgentBooks("1B");
        } );
        // start both threads
        getSeats1.start();
        getSeats2.start();
    }
    public void ticketAgentBooks(String seat){
        // get the one instance of the show Singleton
        Show show = Show.getInstance();
        // book a seat and print
        System.out.println(Thread.currentThread().getName() + ":" + show.bookSeat(seat));
    }
}
