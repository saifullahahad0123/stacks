import java.util.Stack;

public class consecutive {

    public static String removeConsecutive(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            }
        }

        String ans = "";

        for (char ch : stack) {
            ans += ch;
        }

        return ans;
    }

    public static void main(String[] args) {

        String str = "aaabbccdaa";

        System.out.println(removeConsecutive(str));
    }
}