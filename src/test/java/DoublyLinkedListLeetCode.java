import org.example.datastructuresandalgorithms.list.doubly.DoublyLinkedList;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DoublyLinkedListLeetCode {

    @Test
    @Order(1)
    public void swapFirstLast() {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(0);
        doublyLinkedList.append(1);
        doublyLinkedList.append(2);
        doublyLinkedList.append(3);
        doublyLinkedList.append(4);
        doublyLinkedList.append(5);

    }

}
