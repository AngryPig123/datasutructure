import org.example.datastructuresandalgorithms.list.LinkedList;
import org.junit.Assert;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LinkedListTest {

    private static LinkedList linkedList = null;
    private static final int INIT_NODE_VALUE = 3;

    @BeforeEach
    public void before_each() {
        linkedList = new LinkedList(INIT_NODE_VALUE);
    }

    @AfterEach
    public void after_each() {
        linkedList = null;
    }

    @Test
    @Order(1)
    public void linked_list_contract_test() {
        Assertions.assertEquals(INIT_NODE_VALUE, linkedList.getHead().value);
    }

    @Test
    @Order(2)
    public void linked_list_append_test() {
        linkedList.append(5);
        Assertions.assertEquals(5, linkedList.getTail().value);
        Assertions.assertEquals(2, linkedList.getSize());
    }

    @Test
    @Order(3)
    public void linked_list_last_remove() {
        linkedList.append(5);

        Assertions.assertEquals(5, linkedList.removeLast().value);
        Assertions.assertEquals(INIT_NODE_VALUE, linkedList.getTail().value);
        Assertions.assertEquals(1, linkedList.getSize());

        Assertions.assertEquals(INIT_NODE_VALUE, linkedList.removeLast().value);
        Assertions.assertEquals(0, linkedList.getSize());

        Assert.assertThrows(NullPointerException.class, () -> linkedList.removeLast());
    }

    @Test
    @Order(4)
    public void linked_list_pre_append() {
        linkedList.prepend(5);
        Assertions.assertEquals(5, linkedList.getHead().value);
        Assertions.assertEquals(2, linkedList.getSize());
    }

    @Test
    @Order(5)
    public void linked_list_remove_first() {
        Assertions.assertEquals(INIT_NODE_VALUE, linkedList.removeFirst().value);
        Assertions.assertEquals(0, linkedList.getSize());
    }

    @Test
    @Order(6)
    public void linked_list_get() {
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        Assertions.assertEquals(INIT_NODE_VALUE, linkedList.get(0).value);
        Assertions.assertEquals(1, linkedList.get(1).value);
        Assertions.assertEquals(2, linkedList.get(2).value);
        Assertions.assertEquals(3, linkedList.get(3).value);

        Assertions.assertThrows(NullPointerException.class, () -> {
            linkedList.get(4);
        });

        System.out.println(linkedList.checkedLinkedList());
    }

    @Test
    @Order(7)
    public void linked_list_set() {
        //  index : 0, value : 3
        linkedList.append(1);   //  1
        linkedList.append(2);   //  2
        linkedList.append(3);   //  3
        System.out.println(linkedList.checkedLinkedList());

        linkedList.set(1, 11);
        linkedList.set(2, 22);
        linkedList.set(3, 33);
        System.out.println(linkedList.checkedLinkedList());

        Assertions.assertEquals(11, linkedList.get(1).value);
        Assertions.assertEquals(22, linkedList.get(2).value);
        Assertions.assertEquals(33, linkedList.get(3).value);

        Assertions.assertThrows(NullPointerException.class, () -> {
            linkedList.get(4);
        });

    }

    @Test
    @Order(8)
    public void linked_list_insert() {
        //  index : 0, value : 3
        linkedList.append(1);   //  1
        linkedList.append(2);   //  2
        linkedList.append(3);   //  3

        linkedList.insert(0, 10);  //  4
        Assertions.assertEquals(10, linkedList.get(0).value);

        linkedList.insert(5, 15);  //  5
        Assertions.assertEquals(15, linkedList.get(5).value);

        linkedList.insert(3, 15);  //  5
        Assertions.assertEquals(15, linkedList.get(3).value);

        System.out.println(linkedList.checkedLinkedList());
    }

    @Test
    @Order(9)
    public void linked_list_remove() {
        //  index : 0, value : 3
        linkedList.append(1);   //  1
        linkedList.append(2);   //  2
        linkedList.append(3);   //  3
        System.out.println(linkedList.checkedLinkedList());

        linkedList.remove(0);
        Assertions.assertEquals(1, linkedList.getHead().value);
        System.out.println(linkedList.checkedLinkedList());

        linkedList.remove(0);
        Assertions.assertEquals(2, linkedList.getHead().value);
        System.out.println(linkedList.checkedLinkedList());

        linkedList.remove(0);
        Assertions.assertEquals(3, linkedList.getHead().value);
        System.out.println(linkedList.checkedLinkedList());

        linkedList.remove(0);

        Assertions.assertThrows(NullPointerException.class, () -> {
            linkedList.remove(0);
        });
        System.out.println(linkedList.checkedLinkedList());

    }

    @Test
    @Order(10)
    public void linked_list_reverse() {
        linkedList.append(1);   //  1
        linkedList.append(2);   //  2
        linkedList.append(4);   //  3
        System.out.println(linkedList.checkedLinkedList());

        linkedList.reverse();
        System.out.println(linkedList.checkedLinkedList());
    }

}
