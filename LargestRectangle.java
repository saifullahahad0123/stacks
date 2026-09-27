import java.util.Stack;

public class LargestRectangle {

    public static int largestRectangleArea(int[] arr) {

        int n = arr.length;

        // Next Smaller Element
        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

        nse[n - 1] = n;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = st.peek();
            }

            st.push(i);
        }

        // Empty the stack
        while (!st.isEmpty()) {
            st.pop();
        }

        // Previous Smaller Element
        int[] pse = new int[n];

        pse[0] = -1;
        st.push(0);

        for (int i = 1; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = st.peek();
            }

            st.push(i);
        }

        // Find maximum area
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width = nse[i] - pse[i] - 1;

            int area = arr[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 6, 2, 3};

        int ans = largestRectangleArea(arr);

        System.out.println("Largest Rectangle Area = " + ans);
    }
}