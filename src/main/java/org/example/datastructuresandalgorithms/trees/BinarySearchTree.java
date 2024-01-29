package org.example.datastructuresandalgorithms.trees;

public class BinarySearchTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public BinarySearchTree() {
    }   //  left, right 작은값, 큰값

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

    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;
        if (currentNode.value == value) return true;
        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) {
            Node newNode = new Node(value);
            this.root = newNode;
            return newNode;
        }

        if (value < currentNode.left.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.right.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    private Node deleteNode(Node currentNode, int value) {

        return null;
    }

}
