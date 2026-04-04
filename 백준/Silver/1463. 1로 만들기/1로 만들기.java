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
        if (memo[N] == null) {
            if (N % 6 == 0) {
                memo[N] =  Math.min(dp(N - 1, memo), Math.min(dp(N / 3, memo), dp(N / 2, memo))) + 1;
            } else if (N % 3 == 0) {
                memo[N] = Math.min(dp(N / 3, memo), dp(N - 1, memo)) + 1;
            } else if (N % 2 == 0) {
                memo[N] = Math.min(dp(N / 2, memo), dp(N - 1, memo)) + 1;
            } else {
                memo[N] = dp(N - 1, memo) + 1;
            }
        }

        return memo[N];
    }
}
