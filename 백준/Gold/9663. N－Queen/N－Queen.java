import java.util.Scanner;

public class Main {

    private static int[] arr;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.nextLine();

        arr = new int[N];
        int depth = 0;
        backTracking(N, depth);

        System.out.println(count);

        in.close();
    }

    private static void backTracking(int N, int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;

            if (isPossible(depth)) {
                backTracking(N, depth + 1);
            }
        }
    }

    private static boolean isPossible(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[i] == arr[depth]) {
                return false;
            }

            if (depth - i == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}