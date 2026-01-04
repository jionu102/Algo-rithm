import java.util.Scanner;

public class Main {
    private static Integer[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;

        System.out.println(findMin(N));
        in.close();
    }

    private static int findMin(int N) {
        if (dp[N] == null) {
            if (N % 6 == 0) {
                dp[N] = Math.min(findMin(N - 1), Math.min(findMin(N / 3), findMin(N / 2))) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(findMin(N / 3), findMin(N - 1)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(findMin(N / 2), findMin(N - 1)) + 1;
            } else {
                dp[N] = findMin(N - 1) + 1;
            }
        }
        return dp[N];
    }
}