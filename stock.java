import java.util.Stack;

public class stock {
    public static  int[] stockExchange(int[] arr){
        int  n = arr.length;
        int[] arr2 = new int[n];
        arr2[0] = 1;
        Stack<Integer> st = new Stack<>();
        st.push(0);
    for(int i = 1 ; i<n; i++){
        while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
            st.pop();
        }
        if(st.size() == 0) {
            arr2[i] = i-(-1);
        } 
        else
            arr2[i] = i - st.peek();
           st.push(i);
    }
    return arr2;

    } 
    public static void main(String[] args) {
        int[] arr = {5,2,6,1,7,8};
int[] ans = stockExchange(arr);
for(int ele : ans){
    System.out.print(ele + " ");
}
    }
}
