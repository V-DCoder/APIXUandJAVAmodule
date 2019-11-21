package com.sample.hackerrank;

import java.util.ArrayList;

public class MathHomework {

    public static void main(String args[])
    {


        ArrayList<Integer> points = new ArrayList<>();
        points.add(1);
        points.add(2);
        points.add(3);
//        points.add(4);
        points.add(7);
//        points.add(8);

        System.out.println(solve(4,points));


    }

    private static int solve(int threshold, ArrayList<Integer> points) {


        int sc= 1;
        int l = points.size()-1;

        for(int i= 1;i<=l;i++)
        {
            if(threshold ==  points.get(i) - points.get(0) || i==l)
            {
                sc++;

            }else
            {
                    sc++;
                    i++;

            }
            if(threshold <=  points.get(i) - points.get(0))
            {
                return sc;
            }

        }


        return points.size();
    }
}
