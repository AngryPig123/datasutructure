package org.example.datastructuresandalgorithms.trees;

public class BinarySearchTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public BinarySearchTree() {
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        Node temp = this.root;
        if (temp == null) {
            this.root = newNode;
            return true;
        } else {
            while (true) {
                if (temp.value == value) {
                    return false;
                }
                if (value < temp.value) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        return true;
                    } else {
                        temp = temp.left;
                    }
                } else {
                    if (temp.right == null) {
                        temp.right = newNode;
                        return true;
                    } else {
                        temp = temp.right;
                    }
                }
            }
        }
    }

    public boolean contains(int value) {
        Node temp = this.root;
        if (temp != null) {
            while (temp != null) {
                if (value < temp.value) {
                    temp = temp.left;
                } else if (value > temp.value) {
                    temp = temp.right;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

}
