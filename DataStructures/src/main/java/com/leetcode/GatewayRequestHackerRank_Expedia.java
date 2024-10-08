package com.leetcode;

import java.util.*;

/**
 * @author Manoj.Mohanan Nair
 * @Date 10/5/24
 */
public class GatewayRequestHackerRank_Expedia {
    public static void main(String[] args) {
        String[] requests = {
                "google.com", "google.com", "google.com", "google.com", "google.com",
                "yahoo.com", "google.com", "google.com", "yahoo.com", "google.com"
        };
        List<String> result = processRequests(requests);
        for (String status : result) {
            System.out.println(status);
        }
    }

    /**
     * For each domain, maintain two queues:
     * A queue for the requests within the last 5 seconds.
     * A queue for the requests within the last 30 seconds.
     * For each new request, remove requests from the queues that are older than 5 seconds and 30 seconds respectively.
     * After cleaning up the queues, check if the current request can be allowed based on the size of the queues (5 seconds and 30 seconds rules).
     * If the request can be processed, add the request timestamp to both queues and return 200.
     * Otherwise, return 429
     * @param requests
     * @return
     */
    public static List<String> processRequests(String[] requests) {
        // Map to store domain names and their respective request time windows
        Map<String, Deque<Integer>> last5SecMap = new HashMap<>();
        Map<String, Deque<Integer>> last30SecMap = new HashMap<>();

        List<String> result = new ArrayList<>();

        for (int i = 0; i < requests.length; i++) {
            String domain = requests[i];
            int currentTime = i;  // treat i as the current time (second)

            // Initialize deques for the domain if not present
            last5SecMap.putIfAbsent(domain, new LinkedList<>());
            last30SecMap.putIfAbsent(domain, new LinkedList<>());

            Deque<Integer> last5Sec = last5SecMap.get(domain);
            Deque<Integer> last30Sec = last30SecMap.get(domain);

            // Remove requests that are outside the 5 second window
            while (!last5Sec.isEmpty() && last5Sec.peekFirst() <= currentTime - 5) {
                last5Sec.pollFirst();
            }

            // Remove requests that are outside the 30 second window
            while (!last30Sec.isEmpty() && last30Sec.peekFirst() <= currentTime - 30) {
                last30Sec.pollFirst();
            }

            // Check the conditions to allow or reject the request
            if (last5Sec.size() < 2 && last30Sec.size() < 5) {
                // If allowed, add the current time to both queues
                last5Sec.addLast(currentTime);
                last30Sec.addLast(currentTime);
                result.add("200");
            } else {
                // Otherwise, reject the request
                result.add("429");
            }
        }
        return result;
    }
}
