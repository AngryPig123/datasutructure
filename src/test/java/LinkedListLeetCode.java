import org.example.datastructuresandalgorithms.list.LinkedList;
import org.example.datastructuresandalgorithms.list.Node;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LinkedListLeetCode {

    private LinkedList convertArrayToLinkedList(int[] array) {
        LinkedList linkedList = new LinkedList(array[0]);
        for (int i = 1; i < array.length; i++) {
            linkedList.append(array[i]);
        }
        return linkedList;
    }

    private int[] convertLinkedListToArray(LinkedList list) {
        int[] array = new int[list.getSize()];
        int temp = 0;
        Node headNode = list.getHead();
        while (headNode != null) {
            array[temp] = headNode.value;
            headNode = headNode.next;
            temp++;
        }
        return array;
    }

    @Test
    @Order(1)
    public void find_middle_node() {

        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        Node middleNode = myList.findMiddleNode();
        Assertions.assertEquals(3, middleNode.value);

        myList.append(6);
        middleNode = myList.findMiddleNode();
        Assertions.assertEquals(4, middleNode.value);

    }

    @Test
    @Order(2)
    public void hasLoop() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);

        Assertions.assertFalse(myList.hasLoop());
        myList.getTail().next = myList.getHead();

        Assertions.assertTrue(myList.hasLoop());
    }

    @Test
    @Order(3)
    public void findKthFromEnd() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);

        Assertions.assertEquals(5, myList.findKthFromEnd(1).value);
        Assertions.assertEquals(4, myList.findKthFromEnd(2).value);
        Assertions.assertEquals(3, myList.findKthFromEnd(3).value);
        Assertions.assertEquals(2, myList.findKthFromEnd(4).value);
        Assertions.assertEquals(1, myList.findKthFromEnd(5).value);
    }

    @Test
    @Order(4)
    public void partitionList() {

        int[] array = new int[]{3, 8, 5, 10, 2, 1};
        LinkedList linkedList = this.convertArrayToLinkedList(array);

        linkedList.partitionList(5);
        Assertions.assertArrayEquals(new int[]{3, 2, 1, 8, 5, 10}, convertLinkedListToArray(linkedList));

    }


}
