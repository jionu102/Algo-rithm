import java.util.Scanner;

// ----- DP -----
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.nextLine();

        Integer[] memo = new Integer[N + 1];
        memo[0] = memo[1] = 0;

        int count = dp(N, memo);

        System.out.println(count);

        in.close();
    }

    private static int dp(int N, Integer[] memo) {
        for (int i = 2; i <= N; i++) {
            memo[i] = memo[i - 1] + 1;
            if (i % 3 == 0) {
                memo[i] = Math.min(memo[i], memo[i / 3] + 1);
            }

            if (i % 2 == 0) {
                memo[i] = Math.min(memo[i], memo[i / 2] + 1);
            }
        }
        return memo[N];
    }
}