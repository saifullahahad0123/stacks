import java.util.*;

public class printPattren {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        System.out.print("Enter values: ");

        // Input
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // Pattern
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i]; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        sc.close();
    }
}