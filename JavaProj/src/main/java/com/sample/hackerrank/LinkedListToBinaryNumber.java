package com.sample.hackerrank;

public class LinkedListToBinaryNumber {

    public static void main(String args[])
    {

        Node n5 = new Node(1,null);
        Node n4 = new Node(1,n5);
        Node n3 = new Node(0,n4);
        Node n2 = new Node(0,n3);
        Node n1 = new Node(1,n2);
        Node root = new Node(0,n1);

        System.out.println(getDecimalNumber(root));
        System.out.println(getDecimalNumberLong(root));

    }

    private static long getDecimalNumberLong(Node root) {

        Node n = null;
        Node c = root;
        Node p = null;
        while(c!=null)
        {
            n = c.getNext();
            c.setNext(p);
            p = c;
            c = n;

        }
        root = p;
        long base = 0;
        long result = 0;
        while(root!=null)
        {
            base = base == 0 ? 1: base << 1;
            if(root.getData()==1)
            {
                result = result + base;
            }
            root = root.getNext();
        }


        return result;
    }

    private static long getDecimalNumber(Node root) {
        Node rootHolder = root;
        int count =0;
        while(root !=null)
        {
            count++;
            root = root.getNext();
        }
        root = rootHolder;


        boolean[] arr = new boolean[count];

        int i=0;
        while(root !=null)
        {
            arr[i] = root.getData() != 0;
            i++;
            root = root.getNext();
        }
        long base = 0;
        long result = 0;
        for(int ii = arr.length-1;ii>=0;ii--)
        {
            if(base == 0)
            {
                base = 1;
            }else {
                base = base << 1;
            }
            if(arr[ii])
            {
                result = result + base;
            }
        }

        return result;
    }
}
