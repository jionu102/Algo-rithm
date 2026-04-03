import java.util.Scanner;

public class Main {

    private static int N;
    private static int count = 0;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);

        N = in.nextInt();
        in.nextLine();

        arr = new int[N];

        backTracking(0);

        System.out.println(count);

        in.close();
    }

    private static void backTracking(int depth) {
        if (depth == N) {
            count ++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;

            if (possibility(depth)) {
                backTracking(depth + 1);
            }
        }
    }

    private static boolean possibility(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[i] == arr[depth]) {
                return false;
            }

            if (Math.abs(arr[depth] - arr[i]) == depth - i) {
                return false;
            }
        }
        return true;
    }
}