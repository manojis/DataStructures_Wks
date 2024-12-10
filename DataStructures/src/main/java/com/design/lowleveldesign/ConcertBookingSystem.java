package com.design.lowleveldesign;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Check the screenshot for question
 *
 * https://github.com/ashishps1/awesome-low-level-design/tree/main/solutions/java/src/concertbookingsystem
 */
public class ConcertBookingSystem {
    private int numStandardSeats;
    private int numPremiumSeats;
    private int numFloorSeats;

    private Set<Integer> reservedStandardSeats = new HashSet<>();
    private Set<Integer> reservedPremiumSeats = new HashSet<>();
    private int reservedFloorTickets = 0;

    // Map<String, Integer> to track how many tickets each user has booked.
    private Map<String, Integer> userBookingCounts = new HashMap<>();

    private final ReentrantLock lock = new ReentrantLock();

    public ConcertBookingSystem(int numStandard, int numPremium, int numFloor) {
        this.numStandardSeats = numStandard;
        this.numPremiumSeats = numPremium;
        this.numFloorSeats = numFloor;
    }

    // Reserve specific seats
    public boolean reserveSeats(String userId, String seatType, List<Integer> seatNumbers) {
        lock.lock();
        try {
            Set<Integer> reservedSet = getSeatSet(seatType);
            int availableSeats = getAvailableSeats(seatType);
            if (seatNumbers.size() > availableSeats) return false;

            for (int seat : seatNumbers) {
                if (reservedSet.contains(seat)) return false; // Already reserved
            }

            reservedSet.addAll(seatNumbers);
            return true;
        } finally {
            lock.unlock();
        }
    }

    // Reserve floor tickets
    public boolean reserveFloorTickets(String userId, int numTickets) {
        lock.lock();
        try {
            if (reservedFloorTickets + numTickets > numFloorSeats) return false;
            reservedFloorTickets += numTickets;
            return true;
        } finally {
            lock.unlock();
        }
    }

    // Check availability
    public Map<String, Integer> checkAvailability() {
        lock.lock();
        try {
            Map<String, Integer> availability = new HashMap<>();
            availability.put("Standard", numStandardSeats - reservedStandardSeats.size());
            availability.put("Premium", numPremiumSeats - reservedPremiumSeats.size());
            availability.put("Floor", numFloorSeats - reservedFloorTickets);
            return availability;
        } finally {
            lock.unlock();
        }
    }

    private Set<Integer> getSeatSet(String seatType) {
        switch (seatType.toLowerCase()) {
            case "standard":
                return reservedStandardSeats;
            case "premium":
                return reservedPremiumSeats;
            default:
                throw new IllegalArgumentException("Invalid seat type");
        }
    }

    private int getAvailableSeats(String seatType) {
        switch (seatType.toLowerCase()) {
            case "standard":
                return numStandardSeats - reservedStandardSeats.size();
            case "premium":
                return numPremiumSeats - reservedPremiumSeats.size();
            default:
                throw new IllegalArgumentException("Invalid seat type");
        }
    }

    // prevent disbursed booking
    private boolean areSeatsContiguous(List<Integer> seatNumbers) {
        Collections.sort(seatNumbers);
        for (int i = 1; i < seatNumbers.size(); i++) {
            if (seatNumbers.get(i) - seatNumbers.get(i - 1) != 1) return false;
        }
        return true;
    }

    // revoking tickets or waitlists
    public boolean cancelBooking(String userId, String seatType, List<Integer> seatNumbers) {
        lock.lock();
        try {
            // Free seats logic...
            reservedStandardSeats.removeAll(seatNumbers);
            // Adjust user count
            int currentCount = userBookingCounts.getOrDefault(userId, 0);
            userBookingCounts.put(userId, currentCount - seatNumbers.size());
            return true;
        } finally {
            lock.unlock();
        }
    }

    // Waitlist management
    Queue<String> waitlistQueue = new LinkedList<>();

    public void addToWaitlist(String userId) {
        waitlistQueue.add(userId);
    }

    public void notifyWaitlist() {
        if (!waitlistQueue.isEmpty()) {
            String userId = waitlistQueue.poll();
            signalUser(userId);
        }
    }

    public void signalUser(String userId) {
        String message = "A seat is now available for user: " + userId;
        // MessageQueue.publish("UserNotifications", message); // Publish to a message queue
    }
}
