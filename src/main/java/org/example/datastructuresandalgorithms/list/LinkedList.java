package org.example.datastructuresandalgorithms.list;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    private final String EMPTY_MESSAGE = "empty node";

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public LinkedList(int value) {
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.size++;
    }

    public void append(int value) {
        Node node = new Node(value);
        if (this.size == 0) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
        this.size++;
    }

    public Node removeFirst() {
        Node headNode = this.head;
        if (this.getSize() == 0) {
            emptyLinkedListException();
        } else {
            this.head = headNode.next;
            headNode.next = null;
            this.size--;
            if (this.getSize() == 0) {
                this.head = null;
                this.tail = null;
            }
        }
        return headNode;
    }

    public Node removeLast() {
        Node temp = this.head;
        Node pre = this.head;
        if (this.size == 0) {
            emptyLinkedListException();
        } else {
            while (temp.next != null) {
                pre = temp;
                temp = temp.next;
            }
            this.tail = pre;
            this.tail.next = null;  //
            this.size--;
            if (this.getSize() == 0) {
                this.head = null;
                this.tail = null;
            }
        }
        return temp;
    }

    public Node get(int index) {
        if (this.getSize() <= index || index < 0) {
            throw new NullPointerException(EMPTY_MESSAGE);
        } else if (this.getSize() - 1 == index) {
            return this.tail;
        } else {
            Node temp = this.head;
            for (int i = 0; i < index; i++) {   //  해당 부분을 index 값이 맨앞과 맨 뒤중 어디와 가까운지 판별해서
                temp = temp.next;
            }
            return temp;
        }
    }

    public void set(int index, int value) {
        if (this.getSize() < index || index < 0) {
            throw new NullPointerException(EMPTY_MESSAGE);
        }
        this.get(index).value = value;
    }

    public void insert(int index, int value) {
        if (this.getSize() < index || index < 0) {
            throw new NullPointerException(EMPTY_MESSAGE);
        }
        if (index == 0) {
            this.prepend(value);
        } else if (this.getSize() == index) {
            this.append(value);
        } else {
            Node newNode = new Node(value);
            Node temp = this.get(index - 1);
            newNode.next = temp.next;
            temp.next = newNode;
            this.size++;
        }
    }

    private void emptyLinkedListException() {
        throw new NullPointerException(EMPTY_MESSAGE);
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        Node headNode = this.head;
        if (this.getSize() == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head = newNode;
            newNode.next = headNode;
        }
        this.size++;
    }

    public Node remove(int index) {
        if (index < 0 || index >= this.getSize()) {
            throw new NullPointerException(EMPTY_MESSAGE);
        } else if (index == 0) {
            return this.removeFirst();
        } else if (index == this.getSize() - 1) {
            return this.removeLast();
        } else {
            Node prev = this.get(index - 1);
            Node temp = prev.next;
            prev.next = temp.next;
            temp.next = null;
            this.size--;
            return temp;
        }
    }

    public void reverse() {
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        Node after;
        Node before = null;
        for (int i = 0; i < this.getSize(); i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public String checkedLinkedList() {
        if (getSize() == 0) {
            return EMPTY_MESSAGE;
        } else {
            Node headNode = this.head;
            StringBuilder result = new StringBuilder(Integer.toString(headNode.value));
            while (headNode.next != null) {
                result.append(" => ");
                headNode = headNode.next;
                result.append(headNode.value);
            }
            return result.append(", size = ").append(this.getSize()).toString();
        }
    }

}
