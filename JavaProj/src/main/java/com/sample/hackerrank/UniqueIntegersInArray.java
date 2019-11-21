package com.sample.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueIntegersInArray {

    public static void main(String args[]) {
        System.out.println("Hello World");

        ArrayList<Integer> inputArray = new ArrayList<>();
        inputArray.add(2);
        inputArray.add(3);
        inputArray.add(4);
        inputArray.add(4);
        inputArray.add(1);
        inputArray.add(5);
        inputArray.add(10);
        inputArray.add(3);
        inputArray.add(10);
        inputArray.add(4);
        List<Integer> list = abc(inputArray);

        System.out.println("Output : " + list.toString());
    }

    public static List<Integer> abc(List<Integer> list) {
        int length = list.size();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (list.lastIndexOf(list.get(i)) == list.indexOf(list.get(i)) && result.size() < 2) {
                result.add(list.get(i));
            }
        }

        return result;
    }
}
