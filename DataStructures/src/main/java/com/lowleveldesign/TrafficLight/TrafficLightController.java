package com.lowleveldesign.TrafficLight;

import java.util.Scanner;

public class TrafficLightController {
    private TrafficLightState current_state = TrafficLightState.Green;

    public PedestrianCrossController pedestrianCrossController;

    public static void main(String args[]) {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Press 1 for crossing");
        String cross = myObj.nextLine();

        if(cross == "1") {
            TurnToRed();

        }
    }

    public static void TurnToRed() {

    }
}
