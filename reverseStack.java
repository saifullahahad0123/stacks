import java.util.Stack;

public class reverseStack{

    // Reverse the stack
    static void reverse(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }

        // Remove top
        int top = stack.pop();

        // Reverse remaining stack
        reverse(stack);

        // Put removed element at bottom
        pushAtBottom(stack, top);
    }

    // Push an element at the bottom
    static void pushAtBottom(Stack<Integer> stack, int value) {

        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        // Remove top
        int top = stack.pop();

        // Recursively reach bottom
        pushAtBottom(stack, value);

        // Put removed element back
        stack.push(top);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Before: " + stack);

        reverse(stack);

        System.out.println("After:  " + stack);
    }
}