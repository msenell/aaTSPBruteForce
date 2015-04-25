package com.org.example;

/**
 * Created by Mustafa on 26.03.2015.
 */
public class tspFunctions
{
    int cityCount;
    double optDistance;
    String optRoute;
    int cn = 0;

    protected void populate(String s, int k)
    {
        cn++;
        if (cn == 9000000)
        {
            System.out.print(".");
            cn = 0;
        }
        if(k == 0)
        {
            double ds = getDistance(s);
            if(optDistance == 0 || optDistance > ds)
            {
                optDistance = ds;
                optRoute = "" + s;
            }

        }

        for(int i = 0; i<cityCount; i++)
        {
            CharSequence cs = ""+i;
            CharSequence cr;
            if(!s.contains(cs))
            {
                cr = ""+cs;
            }
            else
            {
                continue;
            }
            if(k >= 1)
            {
                populate(s + "-" + cr, k-1);
            }
        }
    }

    private double getDistance(String s)
    {
        String[] route = s.split("-");
        for(int i = 0; i<route.length-1; i++)
        {
            route[i] = route[i+1];
        }
        route[route.length-1] = route[0];
        double distance = 0;
        //System.out.println(route.length);
        for(int i = 0; i<route.length-1; i++)
        {
            if(readToFile.mode)
            {
                distance += readToFile.distMatrix[Integer.parseInt(route[i])][Integer.parseInt(route[i+1])];
            }
            else
            {
                double x, y;
                x = Math.abs(readToFile.coor.get(Integer.parseInt(route[i]))[0] -
                        readToFile.coor.get(Integer.parseInt(route[i + 1]))[0]);
                y = Math.abs(readToFile.coor.get(Integer.parseInt(route[i]))[1] -
                        readToFile.coor.get(Integer.parseInt(route[i + 1]))[1]);
                distance += Math.sqrt(x * x + y * y);
            }
        }
        return distance;
    }
}
