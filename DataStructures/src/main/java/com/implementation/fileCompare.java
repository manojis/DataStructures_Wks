package com.implementation;

import java.io.*;

/**
 * Created by Manoj.Mohanan Nair on 4/9/2017.
 */
public class fileCompare {

    public static void main(String[] args) {
        BufferedReader in = null;
        PrintWriter out = null;


        try {
            System.out.println(System.getProperty("user.dir"));
            in = new BufferedReader(new FileReader("inputfile.txt"));
            out = new PrintWriter("outputfile.txt");

            int copiedval;
            while (((copiedval = in.read()) != -1)) {
                //System.out.println(Character.toString ((char) copiedval));
                out.write(copiedval);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                out.close();
            }
        }
    }


}
