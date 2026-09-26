import java.util.Stack;

public class next {

    public static int[] nextGreaterII(int[] arr) {

        int n = arr.length;

        int[] nag = new int[n];

        Stack<Integer> st = new Stack<>();

        // Put elements into stack
        for (int i = n - 1; i >= 0; i--) {
            st.push(arr[i]);
        }

        // Find next greater element
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nag[i] = -1;
            } else {
                nag[i] = st.peek();
            }

            st.push(arr[i]);
        }

        return nag;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};

        int[] ans = nextGreaterII(arr);

        for (int ele : ans) {
            System.out.print(ele + " ");
        }
    }
}