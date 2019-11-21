package com.sample.hackerrank;

import java.util.HashMap;

public class PerfectSubsString {

    public static void main(String args[])
    {


       String s = "1102021222";
       int k =2;
       int l = s.length()-1;

       for(int i=0;i<l;i++)
       {
           for(int j=i+1;i<l;j++)
           {
                String substr = s.substring(i,j);
               HashMap<Character,Integer> counter = new HashMap<>();
               for(int m=0;m<substr.length();m++)
               {
                   if(counter.containsKey(substr.charAt(m)))
                   {
                   }
               }

           }
       }


    }
}
