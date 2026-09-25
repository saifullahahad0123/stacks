import java.util.Stack;

public class NextGreaterElement2 {

    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

       
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }

        Stack<Integer> st = new Stack<>();

    
        for (int i = 2 * n - 1; i >= 0; i--) {

            int index = i % n;

         
            while (!st.isEmpty() && st.peek() <= nums[index]) {
                st.pop();
            }

       
            if (i < n) {
                if (!st.isEmpty()) {
                    ans[index] = st.peek();
                }
            }

          
            st.push(nums[index]);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};

        int[] ans = nextGreaterElements(nums);

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
