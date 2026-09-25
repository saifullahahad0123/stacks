import java.util.Stack;

public class NextGreater {

    public static int[] nextGreater(int[] arr) {

        int n = arr.length;

        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove smaller elements
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            // If stack is empty, no greater element
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            // Push current element
            st.push(arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {4, 5, 2, 10, 8};

        int[] ans = nextGreater(arr);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
