import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecursionTest {

    @Test
    public void factorial() {
        Assertions.assertEquals(6, factorial(3));
        Assertions.assertEquals(24, factorial(4));
        Assertions.assertEquals(120, factorial(5));
        Assertions.assertEquals(720, factorial(6));
    }

    public int factorial(int repeat) {
        if (repeat == 1) return 1;
        return repeat * factorial(repeat - 1);
    }

    @Test
    public void fibonacci() {
        int[] current = {0};
        System.out.println(fibonacci(12, current));
        System.out.println(current[0]);
    }

    public int fibonacci(int repeat, int[] currentCount) {
        currentCount[0]++;
        if (repeat <= 1) {
            return repeat;
        }
        return fibonacci(repeat - 2, currentCount) + fibonacci(repeat - 1, currentCount);
    }

}
