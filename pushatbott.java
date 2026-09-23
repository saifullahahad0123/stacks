import java.util.Stack;

public class pushatbott {

    static void pushAtBottom(Stack<Integer> stack, int value) {

        // Base case
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        // Remove top element
        int top = stack.pop();

        // Recursively reach the bottom
        pushAtBottom(stack, value);

        // Put the removed element back
        stack.push(top);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Before: " + stack);

        pushAtBottom(stack, 4);

        System.out.println("After: " + stack);
    }
}
