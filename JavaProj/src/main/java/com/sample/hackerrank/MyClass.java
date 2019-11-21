package com.sample.hackerrank;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyClass {


    public static void main(String args[])
    {
        System.out.println("Hello World");

//        Solution("2,3,10,2,4,8,1");

        int x = 2;
            x = x<<2;
//        f1();
        System.out.println(x);

        String s = "fad";
        StringBuilder sb = new StringBuilder(s);
        sb.reverse().toString();

        ArrayList<Integer> result = new ArrayList<>();
        result.add(2);
        result.add(3);
        result.add(4);
        result.add(4);
        result.add(1);
        result.add(5);
        result.add(10);
        result.add(3);
        result.add(10);
        result.add(4);
//    abc(result)/;
    }
    public static List<String>abc(List<String> list)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        try {
            for(int i=0;i<list.size()-1;i++)
            {
                for(int j=i+1;j<list.size();j++)
                {
                    Date d2 = sdf.parse(list.get(j));
                    if(sdf.parse(list.get(i)).compareTo(sdf.parse(list.get(j)))>0);
                    {

                    }
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
return null;
    }



//



























    public static void f1()
    {
        String s = " ram";
        f12(s,3);
        System.out.println( s );
    }

    public static void f12(String s, int i)
    {
 System.out.println( s + "sdsd" +  i + " sx");

 s= "sds";
 i = 5;
        System.out.println( s + "sdsd" +  i + " sx");
    }
    public static int Solution(String test)
    {

        String[] charArr = test.split(",");
        int max= Integer.parseInt(charArr[0]);
        int maxPos=0;
        int min = Integer.parseInt(charArr[0]);
        int length = charArr.length;
        for(int i=0;i<length;i++)
        {
            if(max < Integer.parseInt(charArr[i]))
            {
                max = Integer.parseInt(charArr[i]);
                maxPos=i;
            }
        }

        for(int i=0;i<maxPos;i++)
        {
            if(min > Integer.parseInt(charArr[i]))
            {
                min = Integer.parseInt(charArr[i]);
            }
        }

        return max - min;


    }
}




