package com.linkedlist;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var list = new LinkedList();
        list.AddLast(5);
        list.AddLast(10);
        list.AddLast(20);
        list.AddLast(30);
//        list.AddLast(40);
        System.out.println(list.indexOf(10));
        System.out.println(list.contains(100));
//        list.removeFirst();
//        list.removeLast();
//        System.out.println(list.mysize());
        System.out.println(list.size());
//        list.reverse();
//        System.out.println(list.findNodeFromEnd(1));
        System.out.println(list.getKthFromTheEnd(1));
//        list.print();
        var array = list.toArray();
        System.out.println(Arrays.toString(array));

//        list.findMiddle();
        list.FindMiddle();
    }
}
