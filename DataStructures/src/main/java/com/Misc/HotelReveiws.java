package com.Misc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Manoj.Mohanan Nair on 7/16/2017.
 */
public class HotelReveiws {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(System.getProperty("user.home"));

        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "HotelReviews.txt"));
        Scanner in = new Scanner(System.in);

        // Read dictionary
        String[] words = in.nextLine().split(" ");
        Set<String> dict = new HashSet<String>();
        for (String word : words) {
            dict.add(word.toLowerCase());
        }

        // Read number of reviews
        int m = in.nextInt();

        // Read review
        Map<Integer, Integer> hotel2count = new HashMap<Integer, Integer>(); // hotel ID -> Word Count
        for (int i = 0; i < m; i++) {
            // Read hotel id
            int id = Integer.parseInt(in.next());
            in.nextLine();

            // Put id in map in case of new
            if (!hotel2count.containsKey(id)) {
                hotel2count.put(id, 0);
            }

            // Read review text
            String[] review = in.nextLine().split(" ");
            for (String word : review) {
                // Remove any ' ', ',', '.', '!' or '?' from word
                word = word.replaceAll("[$,.!?]", "").toLowerCase();
                if (dict.contains(word)) {
                    hotel2count.put(id, hotel2count.get(id) + 1);
                }
            }
        }
        // Sort
        //Set<Map.Entry<Integer,Integer>> entry = hotel2count.entrySet();

        //assigning the set to arraylist
        List<Map.Entry<Integer, Integer>> sorted = new ArrayList(hotel2count.entrySet());
        Collections.sort(sorted, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    System.out.println(">>--->" + (o1.getKey() - o2.getKey()));
                    return o1.getKey() - o2.getKey();
                } else {
                    System.out.println("--->" + (o2.getValue() - o1.getValue()));
                    return o2.getValue() - o1.getValue();
                }
            }
        });

        // Print sorted list
        for (Map.Entry<Integer, Integer> hotelEntry : sorted) {
            System.out.print(hotelEntry.getKey() + " ");
        }
    }
}
