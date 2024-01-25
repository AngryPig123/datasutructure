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

    /* leet code method */
    public Node findMiddleNode() {
        Node slowPointer = this.head;
        Node fasterPointer = this.head;
        while (fasterPointer != null && fasterPointer.next != null) {
            slowPointer = slowPointer.next;
            fasterPointer = fasterPointer.next.next;
        }
        return slowPointer;
    }   //  중간 노드 찾기

    public boolean hasLoop() {
        if (this.head == null) {
            return false;
        }
        if (this.tail.next != null) {
            return true;
        }
        Node slowPointer = this.head;
        Node fastPointer = this.head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }   //  루프 확인

    /**
     * If the list has fewer than k nodes, the method should return null.
     */
    public Node findKthFromEnd(int k) {
        Node fastPointer = this.head;
        Node slowPointer = this.head;
        for (int i = 0; i < k; i++) {
            fastPointer = fastPointer.next;
        }
        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }   //  끝에서 k 번째 노드 찾기.

    /**
     * You have a singly linked list that DOES NOT HAVE A TAIL POINTER  (which will make this method simpler to implement).
     * Given a value x you need to rearrange the linked list such that
     * all nodes with a value less than x come before all nodes with a value greater than or equal to x.
     * Additionally, the relative order of nodes in both partitions should remain unchanged.
     * Constraints:
     * The solution should traverse the linked list at most once.
     * The solution should not create a new linked list.
     */
    public void partitionList(int x) {

        if (head == null) return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        //  ***
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;

        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }
        prev2.next = null;
        prev1.next = dummy2.next;
        head = dummy1.next;
    }
    // x를 기준으로 파티션을 나누고 순서대로 정렬하기,
    // argument ) 3 -> 8 -> 5 -> 10 -> 2 -> 1, x: 5
    // return ) 3 -> 2 -> 1 -> 8 -> 5 -> 10

    public void removeDuplicates() {
        // Your implementation goes here
    }

}
