package com.Java_Experimentation.threads;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Manoj.Mohanan Nair
 * @Date 8/23/19
 */
public class Show {
    // create a singleton instance
    private static Show INSTANCE;
    private Set<String> availableSeats;

    public static Show getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Show();
        }
        return INSTANCE;
    }

    private Show() {
        availableSeats = new HashSet<String>();
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    public boolean bookSeat(String seat){
        return availableSeats.remove(seat);
    }
}
