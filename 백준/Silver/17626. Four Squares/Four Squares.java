import java.util.Scanner;

public class Main {

    private static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i ++) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                min =  Math.min(min, dp[i - j * j]);
            }

            dp[i] = min + 1;
        }

        System.out.println(dp[n]);

        in.close();
    }
}
