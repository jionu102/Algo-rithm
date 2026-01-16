import java.util.Scanner;

public class Main {
    private static Integer[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        dp = new Integer[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 3;
        }

        int found = find(n);
        System.out.println(found);

        in.close();
    }

    private static int find(int n) {
        if (dp[n] == null) {
            int additional = n % 2 == 0 ? 1 : -1;
            dp[n] = (find(n - 1) * 2 + additional) % 10007;
        }
        return dp[n];
    }
}
