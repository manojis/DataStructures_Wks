package com.Misc;

import java.util.Scanner;
/**
 * Created by 212561694 on 11/22/2016.
 */
public class PrincessBot_2 {

    static void nextMove(int n, int r, int c, String [] grid){

        int b_xpos = r, b_ypos = c, p_xpos = -1, p_ypos = -1;

        for(int i=0; i<n; i++){
            // find the postion of the princess from the input grid.
            if(grid[i].indexOf('p')> -1){
                p_ypos = i;
                p_xpos = grid[i].indexOf('p');
            }
            if(grid[i].indexOf('m')>-1){
                b_ypos = i;
                b_xpos = grid[i].indexOf('m');
            }
            if(b_xpos >=0 && b_ypos >=0 && p_xpos>=0 && p_ypos>=0){
                break;
            }
        }

        int flag = 0;
        while((b_xpos != p_xpos || b_ypos != p_ypos) &&  flag ==0){
            //Getting the next move based on the current position of the bot and the princess
            if(b_xpos > p_xpos){
                b_xpos--;
                System.out.println("LEFT");
                flag++;
            }
            else if(b_xpos < p_xpos){
                b_xpos++;
                System.out.println("RIGHT");
                flag++;
            }
            if(b_ypos > p_ypos){
                b_ypos--;
                System.out.println("UP");
                flag++;
            }
            else if(b_ypos < p_ypos){
                b_ypos++;
                System.out.println("DOWN");
                flag++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,r,c;
        n = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        in.useDelimiter("\n");
        String grid[] = new String[n];


        for(int i = 0; i < n; i++) {
            grid[i] = in.next();
        }

        nextMove(n,r,c,grid);
    }
}
