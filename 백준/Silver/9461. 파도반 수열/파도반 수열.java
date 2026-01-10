import java.util.Scanner;

public class Main {
    private static final Long[] dp = new Long[101];

    public static void main(String[] args) {
        Scanner in = new  Scanner(System.in);
        int testCases = in.nextInt();
        in.nextLine();
        dp[1] = dp[2] = dp[3] = 1L;
        dp[4] = dp[5] = 2L;

        while (testCases-- > 0) {
            int N = in.nextInt();
            in.nextLine();

            System.out.println(find(N));
        }
        in.close();
    }

    private static long find(int N) {
        if (dp[N] == null) {
            dp[N] = find(N - 1) + find(N - 5);
        }
        return dp[N];
    }
}
