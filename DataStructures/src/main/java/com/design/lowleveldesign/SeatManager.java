package com.design.lowleveldesign;

import java.util.PriorityQueue;

public class SeatManager {
    int seatNumber = 0;
    PriorityQueue<Integer> minHeap;
    //HashMap<Integer, Boolean> reservedSeats = new HashMap<>();

    public SeatManager(int n) {
        minHeap = new PriorityQueue<>(n);
        for(int i=1; i<=n ; i++){
            minHeap.add(i);
        }
    }

    public int reserve() {
        int seat = 0;
        if (!minHeap.isEmpty()) {
            seat = minHeap.poll();
            //reservedSeats.put(seat, true);
        }
        System.out.println(seat);
        return seat;
    }

    public void unreserve(int seatNumber) {
        minHeap.add(seatNumber);
        /*if(reservedSeats.get(seatNumber) != null){
            minHeap.add(seatNumber);
            reservedSeats.put(seatNumber, false);
        }*/
    }

    public static void main(String[] args){
        SeatManager obj = new SeatManager(10);
        int reserved = obj.reserve();
        System.out.println(reserved);
        obj.unreserve(2);
    }
}
