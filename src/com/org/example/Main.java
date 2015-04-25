package com.org.example;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        readToFile rf = new readToFile();
        tspFunctions tf = new tspFunctions();
        Scanner scn = new Scanner(System.in);
        System.out.println("\n" + "1-Distance Matrix" + "\n2-Coordinate List" + "\nPlease select input model:");
        int selection = scn.nextInt();
        if(selection == 2) {
            rf.mode = false;
            rf.ReadToTxt();
            tf.cityCount = readToFile.coor.size();
        }
        else if(selection == 1) {
            rf.mode = true;
            rf.ReadToTxt();
            tf.cityCount = readToFile.distMatrix.length;
        }
        else
            System.exit(0);
        System.out.println("City Count : " + tf.cityCount);
        long startTime = System.currentTimeMillis();
        tf.populate("", tf.cityCount);
        long endTime = System.currentTimeMillis();

        String s = "";
        for(int i = 1; i<tf.optRoute.length(); i++)
        {
            if(tf.optRoute.charAt(i) != '-')
                s += Character.getNumericValue(tf.optRoute.charAt(i)) + 1;
            else
                s += tf.optRoute.charAt(i);
        }
        System.out.println();
        System.out.println("Optimal Length : " + tf.optDistance + "\n" + "Route : " + s);
        System.out.println("Operation Time : " + (endTime-startTime)/1000.0 + " seconds");
    }
}
