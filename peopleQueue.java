import java.util.Stack;

public class peopleQueue {
    public static int[] people(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        ans[n-1] = 0;
        st.push(arr[n-1]);
        for(int i = n-2;i>=0; i--){
             int count = 0 ;
             while (!st.isEmpty() && arr[i] >= st.peek()) {
                count++;
                st.pop();
             }
             if(st.size()>0){
                count++;
             }
             ans[i] = count;
            st.push(arr[i]); 
             
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {3,5,7,8,1,4,4};
        int[] e = people(arr);

 for(int ele : e){
    System.out.print(ele + " ");
 }
    }
}
