import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] target = new int[n];

        for (int i = 0; i < n; i++) {
            target[i] = in.nextInt();
        }

        int[] arr = target.clone();

        Arrays.sort(arr);

        boolean stack_possible = true;

        Stack<Integer> stack = new Stack<>();

        int arr_index = 0;
        int target_index = 0;
        StringBuilder str = new StringBuilder();

        while (arr_index < n) {

            stack.push(arr[arr_index++]);
            str.append("+\n");

            while (!stack.isEmpty() && stack.peek() == target[target_index]) {
                stack.pop();
                str.append("-\n");
                target_index++;
            }

        }

        if (stack.isEmpty()) {
            System.out.println(str);
        } else {
            System.out.println("NO");
        }
        in.close();
    }
}
