package com.sample.hackerrank;

import java.util.Arrays;

public class UmbrellasForPeoples {

    public static void main(String args[])
    {
        int[] arr = {5,3};
       System.out.println(calculateNumber(5,arr));
    }

    private static int calculateNumber(int n, int[] arr) {

        Arrays.sort(arr);

        for(int i=arr.length-1;i>=0;i--)
        {
            if(arr[i]==n)
            {

                return 1;
            }
        }

        int[] result =new int[20];
        for(int i=arr.length-1;i>=0;i--)
        {
            int umbrelaRequired=n/arr[i];
            int reminderPeople = n%arr[i];
            for(int j = i-1;j>=0;j--) {
                if (arr[j] <= reminderPeople && reminderPeople > 0) {
                    umbrelaRequired += reminderPeople / arr[j];
                    reminderPeople = reminderPeople % arr[j];
                }


            }
            if(reminderPeople==0)
            {
                return  umbrelaRequired;
            }
        }




return -1;
    }
}
