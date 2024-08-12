import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            int r = in.nextInt();

            if(r == 0) stack.pop();
            else stack.push(r);
        }

        for (int r : stack) {
            sum += r;
        }

        System.out.println(sum);
        in.close();
    }
}
