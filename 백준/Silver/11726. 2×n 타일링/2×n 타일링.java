import java.util.Scanner;

public class Main {
    private static Integer[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        dp = new Integer[n + 1];
        dp[0] = 0; dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
        }

        System.out.println(find(n));
    }

    private static int find(int n) {
        if (dp[n] == null) {
            dp[n] = (find(n - 1) + find(n - 2)) % 10007;
        }
        return dp[n];
    }
}
