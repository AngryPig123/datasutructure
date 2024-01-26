import org.example.datastructuresandalgorithms.list.doubly.DoublyLinkedList;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DoublyLinkedListTest {

    private static DoublyLinkedList DOUBLE_LINKED_LIST;
    private static final int INIT_VALUE = 0;

    @BeforeEach
    public void beforeEach() {
        DOUBLE_LINKED_LIST = new DoublyLinkedList(INIT_VALUE);
    }

    @AfterEach
    public void afterEach() {
        DOUBLE_LINKED_LIST = null;
    }

    @Test
    @Order(1)
    public void construct() {
        Assertions.assertEquals(DOUBLE_LINKED_LIST.getHead(), DOUBLE_LINKED_LIST.getTail());
        Assertions.assertEquals(1, DOUBLE_LINKED_LIST.getSize());
    }

    @Test
    @Order(2)
    public void append() {

        DOUBLE_LINKED_LIST.append(4);
        Assertions.assertEquals(4, DOUBLE_LINKED_LIST.getTail().value);


        DOUBLE_LINKED_LIST.append(6);
        Assertions.assertEquals(6, DOUBLE_LINKED_LIST.getTail().value);
        Assertions.assertEquals(4, DOUBLE_LINKED_LIST.getTail().prev.value);

        DOUBLE_LINKED_LIST.append(8);
        Assertions.assertEquals(8, DOUBLE_LINKED_LIST.getTail().value);
        Assertions.assertEquals(6, DOUBLE_LINKED_LIST.getTail().prev.value);

    }

    @Test
    @Order(3)
    public void removeLast() {

        DOUBLE_LINKED_LIST.append(2);
        DOUBLE_LINKED_LIST.append(3);
        DOUBLE_LINKED_LIST.append(4);
        DOUBLE_LINKED_LIST.append(5);

        Assertions.assertEquals(5, DOUBLE_LINKED_LIST.removeLast().value);
        Assertions.assertEquals(4, DOUBLE_LINKED_LIST.getSize());

        Assertions.assertEquals(4, DOUBLE_LINKED_LIST.removeLast().value);
        Assertions.assertEquals(3, DOUBLE_LINKED_LIST.getSize());

        Assertions.assertEquals(3, DOUBLE_LINKED_LIST.removeLast().value);
        Assertions.assertEquals(2, DOUBLE_LINKED_LIST.getSize());

        Assertions.assertEquals(2, DOUBLE_LINKED_LIST.removeLast().value);
        Assertions.assertEquals(1, DOUBLE_LINKED_LIST.getSize());


    }

    @Test
    @Order(4)
    public void prepend() {

        DOUBLE_LINKED_LIST.prepend(2);
        Assertions.assertEquals(2, DOUBLE_LINKED_LIST.getHead().value);

        DOUBLE_LINKED_LIST.prepend(3);
        Assertions.assertEquals(3, DOUBLE_LINKED_LIST.getHead().value);

        DOUBLE_LINKED_LIST.prepend(4);
        Assertions.assertEquals(4, DOUBLE_LINKED_LIST.getHead().value);

        DOUBLE_LINKED_LIST.prepend(5);
        Assertions.assertEquals(5, DOUBLE_LINKED_LIST.getHead().value);

        DOUBLE_LINKED_LIST.prepend(6);
        Assertions.assertEquals(6, DOUBLE_LINKED_LIST.getHead().value);

        DOUBLE_LINKED_LIST.prepend(7);
        Assertions.assertEquals(7, DOUBLE_LINKED_LIST.getHead().value);

    }

    @Test
    @Order(5)
    public void removeFirst() {

        Assertions.assertEquals(INIT_VALUE, DOUBLE_LINKED_LIST.removeFirst().value);

        DOUBLE_LINKED_LIST.prepend(5);
        Assertions.assertEquals(5, DOUBLE_LINKED_LIST.removeFirst().value);

        DOUBLE_LINKED_LIST.prepend(22);
        Assertions.assertEquals(22, DOUBLE_LINKED_LIST.removeFirst().value);

        DOUBLE_LINKED_LIST.prepend(11);
        Assertions.assertEquals(11, DOUBLE_LINKED_LIST.removeFirst().value);

        DOUBLE_LINKED_LIST.prepend(55);
        Assertions.assertEquals(55, DOUBLE_LINKED_LIST.removeFirst().value);

        DOUBLE_LINKED_LIST.prepend(555);
        Assertions.assertEquals(555, DOUBLE_LINKED_LIST.removeFirst().value);

        DOUBLE_LINKED_LIST.prepend(4112321);
        Assertions.assertEquals(4112321, DOUBLE_LINKED_LIST.removeFirst().value);

        Assertions.assertThrows(NullPointerException.class, () -> {
            DOUBLE_LINKED_LIST.removeFirst();
        });

    }

    @Test
    @Order(6)
    public void get() {

        DOUBLE_LINKED_LIST.append(1);   //  1
        DOUBLE_LINKED_LIST.append(2);   //  2
        DOUBLE_LINKED_LIST.append(3);   //  3
        DOUBLE_LINKED_LIST.append(4);   //  4
        DOUBLE_LINKED_LIST.append(5);   //  5

        Assertions.assertEquals(0, DOUBLE_LINKED_LIST.get(0).value);
        Assertions.assertEquals(1, DOUBLE_LINKED_LIST.get(1).value);
        Assertions.assertEquals(2, DOUBLE_LINKED_LIST.get(2).value);
        Assertions.assertEquals(3, DOUBLE_LINKED_LIST.get(3).value);
        Assertions.assertEquals(4, DOUBLE_LINKED_LIST.get(4).value);
        Assertions.assertEquals(5, DOUBLE_LINKED_LIST.get(5).value);

    }

    @Test
    @Order(7)
    public void set() {

        DOUBLE_LINKED_LIST.append(1);   //  1
        DOUBLE_LINKED_LIST.append(2);   //  2
        DOUBLE_LINKED_LIST.append(3);   //  3
        DOUBLE_LINKED_LIST.append(4);   //  4
        DOUBLE_LINKED_LIST.append(5);   //  5

        Assertions.assertEquals(1, DOUBLE_LINKED_LIST.get(1).value);
        Assertions.assertEquals(2, DOUBLE_LINKED_LIST.get(2).value);
        Assertions.assertEquals(3, DOUBLE_LINKED_LIST.get(3).value);
        Assertions.assertEquals(4, DOUBLE_LINKED_LIST.get(4).value);
        Assertions.assertEquals(5, DOUBLE_LINKED_LIST.get(5).value);

        DOUBLE_LINKED_LIST.set(1, 100);
        DOUBLE_LINKED_LIST.set(2, 200);
        DOUBLE_LINKED_LIST.set(3, 300);
        DOUBLE_LINKED_LIST.set(4, 400);
        DOUBLE_LINKED_LIST.set(5, 500);

        Assertions.assertEquals(100, DOUBLE_LINKED_LIST.get(1).value);
        Assertions.assertEquals(200, DOUBLE_LINKED_LIST.get(2).value);
        Assertions.assertEquals(300, DOUBLE_LINKED_LIST.get(3).value);
        Assertions.assertEquals(400, DOUBLE_LINKED_LIST.get(4).value);
        Assertions.assertEquals(500, DOUBLE_LINKED_LIST.get(5).value);

    }

    @Test
    @Order(8)
    public void insert() {

        DOUBLE_LINKED_LIST.append(1);   //  1
        DOUBLE_LINKED_LIST.append(2);   //  2
        DOUBLE_LINKED_LIST.append(3);   //  3
        DOUBLE_LINKED_LIST.append(4);   //  4
        DOUBLE_LINKED_LIST.append(5);   //  5

        DOUBLE_LINKED_LIST.insert(2, 200);
        Assertions.assertEquals(200, DOUBLE_LINKED_LIST.get(2).value);
        Assertions.assertEquals(2, DOUBLE_LINKED_LIST.get(3).value);

        DOUBLE_LINKED_LIST.insert(2, 2000);
        Assertions.assertEquals(2000, DOUBLE_LINKED_LIST.get(2).value);
        Assertions.assertEquals(200, DOUBLE_LINKED_LIST.get(3).value);
        Assertions.assertEquals(2, DOUBLE_LINKED_LIST.get(4).value);

    }

    @Test
    @Order(9)
    public void remove() {

        DOUBLE_LINKED_LIST.append(1);   //  1
        DOUBLE_LINKED_LIST.append(2);   //  2
        DOUBLE_LINKED_LIST.append(3);   //  3
        DOUBLE_LINKED_LIST.append(4);   //  4
        DOUBLE_LINKED_LIST.append(5);   //  5

        Assertions.assertEquals(5, DOUBLE_LINKED_LIST.remove(5).value);
        Assertions.assertEquals(2, DOUBLE_LINKED_LIST.remove(2).value);


    }

}





