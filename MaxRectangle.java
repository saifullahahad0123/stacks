import java.util.Stack;

public class MaxRectangle {

    // Largest Rectangle in Histogram
    public static int largestRectangleArea(int[] arr) {

        int n = arr.length;

        int[] nse = new int[n];
        int[] pse = new int[n];

        Stack<Integer> st = new Stack<>();

        // Next Smaller Element
        nse[n - 1] = n;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty())
                nse[i] = n;
            else
                nse[i] = st.peek();

            st.push(i);
        }

        // Empty stack
        st.clear();

        // Previous Smaller Element
        pse[0] = -1;
        st.push(0);

        for (int i = 1; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty())
                pse[i] = -1;
            else
                pse[i] = st.peek();

            st.push(i);
        }

        // Calculate maximum area
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width = nse[i] - pse[i] - 1;

            int area = arr[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }


    // Maximal Rectangle in Binary Matrix
    public static int maximalRectangle(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] height = new int[cols];

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            // Build histogram
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == 1) {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            // Find largest rectangle in current histogram
            int area = largestRectangleArea(height);

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }


    public static void main(String[] args) {

        int[][] matrix = {
            {1, 0, 1, 0, 0},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0}
        };

        int ans = maximalRectangle(matrix);

        System.out.println("Maximum Rectangle Area = " + ans);
    }
}
