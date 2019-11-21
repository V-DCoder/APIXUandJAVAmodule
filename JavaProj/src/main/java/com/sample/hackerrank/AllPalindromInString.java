package com.sample.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class AllPalindromInString {

    public static List<String> allPalindromeSubstring(String s)
    {
        List<String> list = new ArrayList<String>();

        for (float mark = 0; mark < s.length(); mark += .5) {

            float r = mark - (int)mark;

            while ((mark + r) < s.length()
                    && (mark - r) >= 0
                    && s.charAt((int)(mark - r))
                    == s.charAt((int)(mark + r))) {

                list.add(s.substring((int)(mark - r),
                        (int)(mark + r + 1)));

                r++;
            }
        }

        return list;
    }

    // Drivers code
    public static void main(String[] args)
    {
        List<String> list = allPalindromeSubstring("hellolle");
        System.out.println(list.size());
        System.out.println(list);
        list = allPalindromeSubstring("geeksforgeeks");
        System.out.println(list.size());
        System.out.println(list);
    }
}
