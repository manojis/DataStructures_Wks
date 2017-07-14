package com.Puzzles;

/**
 * Created by 212561694 on 2/28/2017.
 */
public class TowerOfHanoi {
    private static MyDynamicStack[] tower;

    public static void towersOfHanoi(int n) {

        // create three stacks, tower[0] is scratch
        tower = new MyDynamicStack[4];
        for (int i = 0; i <= 3; i++) {
            tower[i] = new MyDynamicStack(4);
        }
        for (int d = n; d > 0; d--) {
            // initialize
            // add disk d to tower 1
            tower[1].push(new Integer(d));
        }
        // move n disks from tower 1 to 2 using 3 as
        // intermediate tower
        showTowerStates(n, 1, 2, 3);
    }

    public static void showTowerStates(int n, int x, int y, int z) {

        if (n > 0) {
            try {
                showTowerStates(n - 1, x, z, y);
                // move d from top of tower x
                Integer d = (Integer) tower[x].pop();
                // to top of tower y
                tower[y].push(d);
                System.out.println("Move disk " + d + " from tower " + x + " to top of tower " + y);
                showTowerStates(n - 1, z, y, x);
            } catch (Exception ex) {
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Running 3 disk problem:");
        towersOfHanoi(3);
    }
}
