import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();
        int M = in.nextInt();
        in.nextLine();

        int[] arr = new int[M];
        int[] stack = new int[M + 1];
        stack[0] = 1;
        int depth = 0;

        while (depth >= 0) {
            // 종료 조건
            if (depth == M) {
                for (int num : arr) {
                    sb.append(num).append(' ');
                }
                sb.append('\n');
                depth--;
                stack[depth]++;
                continue;
            }

            int i = stack[depth];
            // 재귀에서 for 소진 → 함수 종료 대신 depth-- 로 상위로 복귀
            if (i > N) {
                depth--;
                if (depth >= 0) {
                    stack[depth]++;
                }
            }
            // 재귀 로직
            else {
                arr[depth] = i;
                depth++;
                stack[depth] = i + 1;
            }
        }

        System.out.println(sb);

        in.close();
    }
}