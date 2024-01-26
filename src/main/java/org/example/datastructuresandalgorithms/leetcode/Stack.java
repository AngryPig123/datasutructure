package org.example.datastructuresandalgorithms.leetcode;

import java.util.ArrayList;

public class Stack<T> {

    private ArrayList<T> stackList = new ArrayList<>();

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public void printStack() {
        for (int i = stackList.size() - 1; i >= 0; i--) {
            System.out.print(stackList.get(i) + " : ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public int size() {
        return stackList.size();
    }

    public void push(T value) {
        this.stackList.add(value);
    }

    public T pop() {
        int size = this.stackList.size();
        if (size == 0) return null;
        T t = this.stackList.get(size - 1);
        this.stackList.remove(t);
        return t;
    }

}
