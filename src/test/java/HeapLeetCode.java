import org.example.datastructuresandalgorithms.heaps.Heap;
import org.junit.jupiter.api.Test;

public class HeapLeetCode {


    @Test
    public void heap_swap() {
        Heap heap = new Heap();
        heap.insert(7);
        heap.insert(10);
        heap.insert(30);
        heap.insert(40);
        heap.insert(50);
        heap.insert(100);
        heap.insert(1000);
        heap.insert(5);
        heap.insert(55);

        heap.printHeapTree();
        heap.remove();
        heap.printHeapTree();

    }


}
