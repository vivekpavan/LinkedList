package com.linkedlist;

import com.sun.source.tree.ClassTree;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }
    }
    private Node first;
    private Node last;
    private int size;

    public void AddLast(int item){
        var node = new Node(item);
        if(isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }
    public void AddFirst(int item){
        var node = new Node(item);
        if(isEmpty())
            first = last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }
    public int indexOf(int item){
        int index = 0;
        var current = first;
        while(current != null){
            if(current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }
    public boolean contains(int item){
        var current = first;
        while(current != null){
            if(current.value == item) return true;
            current = current.next;
        }
        return false;
    }
    public void removeFirst(){
        if(isEmpty()){
            throw new IllegalArgumentException("the list is empty");
        }
        if(first == last){
            first = last = null;
            size = 0;
            return;
        }
        else{
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }
    public void print(){
        var current = first;
        while(current.next != null){
            System.out.println(current.value);
            current  = current.next;
        }
        System.out.println(last.value);
    }
    public void removeLast(){
        if(isEmpty()){
            throw new IllegalArgumentException();
        }
        if(first == last){
            first = last = null;
            size = 0;
            return;
        }
        var current = first;
        while(current.next != last){
            current = current.next;
        }
        last = current;
        last.next = null;
        size--;
    }
    public int size(){
        return size;
    }
    public int mysize(){
        if (isEmpty()){
            return 0;
        }
        var count = 0;
        var current =first;
        while(current.next != null){
            current = current.next;
            count++;
        }
        count += 1;
        return count;
    }


    public int[] toArray(){
        var array = new int[size];
        var current = first;
        while(true){
            for(var i=0;i<size;i++){
                array[i] = current.value;
                current = current.next;
            }
            if(current == null) return array;
        }
    }
    public void reverse() {
        if(isEmpty()){
            return;
        }
        var previous = first;
        var current = first.next;
        while (current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    //Uneffective Way : O(n)
    public int findNodeFromEnd(int node){
        if(node == 0){
            throw new NullPointerException("A node cannot be in 0th place");
        }
        var current = first;
        var iterate = size() - node;
        var count = 0;
        while(count != iterate){
            current = current.next;
            count++;
        }
        return current.value;
    }
    public int getKthFromTheEnd(int k){
        if(isEmpty()){
            throw new IllegalArgumentException();
        }
        var a = first;
        var b = first;
        for(var i=0;i<k-1;i++){
            b = b.next;
            if(b == null) throw new IllegalArgumentException();
        }
        while(b != last){
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    //effective way of finding middle
    public void FindMiddle(){
        var a =first;
        var b =first;
        while(b != last && b.next != last){
            b = b.next.next;
            a = a.next;
        }
        if(b == last){
            System.out.println(a.value);
        }
        else
            System.out.println(a.value+","+a.next.value);
    }

    // the below method is not preferred as it makes use of size() method;
    public void findMiddle(){
        var a = first;
        var b = first;
        var k = Math.floor(size() / 2);
        for(var i=0;i<k;i++){
            b = b.next;
            if(b==null){
                throw new IllegalArgumentException();
            }
        }
        while (b != last){
            a = a.next;
            b = b.next;
        }
        if(size() % 2 == 0){
            System.out.println(a.value+","+a.next.value);
        }
        else
            System.out.println(a.value);
    }

    private boolean isEmpty(){
        return first == null;
    }
}
