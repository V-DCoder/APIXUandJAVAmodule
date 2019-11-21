package com.sample.hackerrank;

public class ReverseLinkedList {

    public static void main(String args[])
    {

        Node n5 = new Node(1,null);
        Node n4 = new Node(1,n5);
        Node n3 = new Node(0,n4);
        Node n2 = new Node(0,n3);
        Node n1 = new Node(1,n2);
        Node root = new Node(0,n1);

        System.out.println(reverseLinkedList(root));

    }

    private static Node reverseLinkedList(Node root) {
        Node rootHoldet = root;

        Node next = null;
        Node current = root;
        Node previous = null;

        System.out.println("Befor reversr: ");
        while(current!=null)
        {
            System.out.print(" " + current.getData() + " ");
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;

        }

        root = previous;
        System.out.println("after reversr: ");

        while(root!=null)
        {
            System.out.print(" " + root.getData() + " ");
            root = root.getNext();

        }


return null;
    }
}
