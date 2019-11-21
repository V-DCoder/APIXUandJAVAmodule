package com.sample.hackerrank;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

class GFG
{

    // Link list Node /
    static class Node
    {
        int data;
        Node next;
    };

    // Returns decimal value of binary linked list /
    static int decimalValue( Node head)
    {




        // Initialized result
        int res = 0;

        // Traverse linked list
        ArrayList<Integer> lst = new ArrayList<>();
        while (head != null)
        {
            // Multiply result by 2 and add
            // head's data
//            res = (res << 1) + head.data;
            lst.add(head.data);
            // Move next
            head = head.next;
        }

        for(int i=lst.size()-1;i>=0;i--)
        {
            res = (res << 1) + lst.get(i);
        }
        return res;
    }

    // Utility function to create a new node.


    static Node newNode(int data)
    {
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }

    // Driver code/
    public static void main(String args[])
    {
        // Start with the empty list /
        Node head = newNode(0);
        head.next = newNode(1);
        head.next.next = newNode(0);
        head.next.next.next = newNode(1);
        head.next.next.next.next = newNode(1);
        head.next.next.next.next.next = newNode(0);
        head.next.next.next.next.next.next = newNode(0);

        System.out.print( "Decimal value is "+decimalValue(head));
    }
}
