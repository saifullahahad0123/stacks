import java.util.Stack;

public class traversal {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        while (!stack.isEmpty()) {
             int top =  stack.pop();
            System.out.println(top);
             stack2.push(top);
            }
         while (!stack.isEmpty()) {
            stack.push(stack2.pop());
            
            }

    }
}