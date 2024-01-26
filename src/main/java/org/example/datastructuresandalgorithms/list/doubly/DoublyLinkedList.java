package org.example.datastructuresandalgorithms.list.doubly;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public DoublyLinkedList(int value) {
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.size++;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (this.getSize() == 0) {
            this.head = newNode;

        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
        }
        this.tail = newNode;
        this.size++;
    }

    public Node removeLast() {
        if (this.getSize() == 0) {
            throw new NullPointerException("empty");
        }
        Node temp = this.tail;
        if (this.getSize() == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
            temp.prev = null;   //  참조를 끊어낸다.
        }
        this.size--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (this.getSize() == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public Node removeFirst() {
        Node temp = this.head;
        if (this.getSize() == 0) {
            throw new NullPointerException("empty");
        } else if (this.getSize() == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = temp.next;
            temp.next = null;
            temp.prev = null;
        }
        this.size--;
        return temp;
    }

    public Node get(int index) {
        if (this.getSize() <= index || index < 0) {
            return null;
        }
        Node temp = this.head;
        if (index < this.getSize() / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = this.tail;
            for (int i = this.getSize() - 1; i > index; i--) {  //  ToDO
                temp = temp.prev;
            }
        }
        return temp;
    }

    public void set(int index, int value) {
        Node node = this.get(index);
        node.value = value;
    }

    public void insert(int index, int value) {
        if (index == 0) {
            prepend(value);
        } else if (this.getSize() == index) {
            append(value);
        } else {
            Node newNode = new Node(value);
            Node temp = this.get(index);
            newNode.prev = temp.prev;
            temp.prev.next = newNode;
            newNode.next = temp;
            temp.prev = newNode;
            this.size++;
        }
    }

    public Node remove(int index) {
        Node temp = this.get(index);
        if (index >= this.getSize() || index < 0) {
            return null;
        } else if (this.getSize() - 1 == index) {
            removeLast();
        } else if (index == 0) {
            removeFirst();
        }else{
            Node before = temp.prev;
            Node after = temp.next;
            before.next = after;
            after.prev = before;
            temp.prev = null;
            temp.next = null;
            this.size--;
        }
        return temp;
    }

}














