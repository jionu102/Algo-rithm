import java.util.Scanner;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private static int[] arr;
    private static int N;
    private static int M;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        N = in.nextInt();
        M = in.nextInt();
        in.nextLine();

        arr = new int[M];

        dfs(1, 0);
        System.out.println(sb);

        in.close();
    }

    public static void dfs(int start, int depth) {
        if (depth >= M) {
            for (int num : arr) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}