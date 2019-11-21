package com.sample.hackerrank;

import java.util.Arrays;

public class BreakStonsWithStons {

    public static void main(String args[])
    {
        int[] arr = {1,2,3,6,7,7};
        System.out.println(stonsCrash(arr));
    }

    private static int stonsCrash(int[] arr) {

        Arrays.sort(arr);

        for(int i=arr.length-1;i>=1;i--)
        {
            int remaining = arr[i] - arr[i-1];
            arr[i-1] = remaining<0?remaining*-1:remaining;
        }

        return arr[0];

    }
}
