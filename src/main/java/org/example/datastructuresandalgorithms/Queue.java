package org.example.datastructuresandalgorithms;

public class Queue {

    private Node first;
    private Node last;
    private int length;

    public Queue(int value) {
        Node node = new Node(value);
        this.first = node;
        this.last = node;
        this.length++;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (this.length == 0) {
            this.first = newNode;
        } else {
            newNode.next = this.last;
        }
        this.last = newNode;
        this.length++;
    }

    public Node dequeue() {
        if (this.length == 0) {
            return null;
        }
        Node temp = this.first;
        this.first = this.first.next;
        this.length--;
        if (this.length == 0) {
            this.last = null;
        }
        return temp;
    }

}
