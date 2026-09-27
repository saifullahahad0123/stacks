import java.util.Stack;

public class MinStack{

    Stack<Integer> st;
    Stack<Integer> minSt;

    MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int val) {

        st.push(val);

        if (minSt.isEmpty() || val <= minSt.peek()) {
            minSt.push(val);
        }
    }

   
    public void pop() {

        if (st.peek().equals(minSt.peek())) {
            minSt.pop();
        }

        st.pop();
    }

  
    public int top() {
        return st.peek();
    }


    public int getMin() {
        return minSt.peek();
    }

    public static void main(String[] args) {

        MinStack obj = new MinStack();

        obj.push(5);
        obj.push(3);
        obj.push(7);
        obj.push(2);
        obj.push(4);

        System.out.println("Top = " + obj.top());
        System.out.println("Minimum = " + obj.getMin());

        obj.pop();

        System.out.println("After pop:");
        System.out.println("Top = " + obj.top());
        System.out.println("Minimum = " + obj.getMin());
    }
}