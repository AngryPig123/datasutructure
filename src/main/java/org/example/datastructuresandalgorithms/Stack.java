package org.example.datastructuresandalgorithms;

public class Stack {

    private Node top;
    private int height;

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }

    public Stack(int value) {
        this.top = new Node(value);
        this.height++;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (this.height != 0) {
            newNode.next = this.top;
        }
        this.top = newNode;
        this.height++;
    }

    public Node pop() {

        if (this.height == 0) {
            return null;
        } else {
            Node temp = this.top;
            this.top = temp.next;
            temp.next = null;   //
            this.height--;
            return temp;
        }

    }

}
