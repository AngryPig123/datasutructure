import org.example.datastructuresandalgorithms.leetcode.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackAndQueueLeetCode {

    @Test
    public void reverseString() {
        String myString = "hello";
        Assertions.assertEquals("olleh", reverseString(myString));
    }

    public String reverseString(String msg) {
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            stack.push(msg.charAt(i));
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    @Test
    public void isBalancedParentheses() {
        Assertions.assertTrue(isBalancedParentheses("((()))"));
        Assertions.assertTrue(isBalancedParentheses("()"));
        Assertions.assertTrue(isBalancedParentheses("()()"));
        Assertions.assertTrue(isBalancedParentheses("(())"));
        Assertions.assertTrue(isBalancedParentheses("()()()"));
        Assertions.assertTrue(isBalancedParentheses("(()())"));
        Assertions.assertFalse(isBalancedParentheses(")()(("));
        Assertions.assertFalse(isBalancedParentheses(")(("));
        Assertions.assertFalse(isBalancedParentheses("(()"));
        Assertions.assertFalse(isBalancedParentheses("))"));
        Assertions.assertFalse(isBalancedParentheses("(("));
        Assertions.assertFalse(isBalancedParentheses(")"));
    }

    public boolean isBalancedParentheses(String msg) {
        if (msg.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < msg.length(); i++) {
            Character peek = stack.peek();
            char tempChar;
            char current = msg.charAt(i);
            if (!stack.isEmpty()) {
                if (peek == '(') {
                    tempChar = ')';
                } else {
                    tempChar = '(';
                }
                if (tempChar == current) {
                    stack.pop();
                } else {
                    stack.push(current);
                }
            } else {
                stack.push(current);
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void sortStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.printStack();
        sortStack(stack);
        stack.printStack();
    }

    public void sortStack(Stack<Integer> stack) {
        Stack<Integer> auxStack = new Stack<>();
        // 원래 스택이 빌 때까지 반복
        while (!stack.isEmpty()) {
            // 원래 스택에서 값을 하나씩 빼기
            int temp = stack.pop();
            // 보조 스택에서 원래 스택에 정렬된 상태로 값 넣기
            while (!auxStack.isEmpty() && auxStack.peek() > temp) {
                stack.push(auxStack.pop());
            }
            auxStack.push(temp);
        }
        // 보조 스택의 내용을 다시 원래 스택으로 옮기기
        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
    }   //  ToDO

}







