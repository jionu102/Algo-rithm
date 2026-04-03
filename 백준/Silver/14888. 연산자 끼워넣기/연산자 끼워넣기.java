import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    private static int N;

    private static int[] numbers;
    private static char[] selectOper;

    private static final int[] operCount = new int[4];
    private static final char[] oper = new char[]{'+', '-', '*', '/'};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        numbers = new int[N];
        selectOper = new char[N - 1];

        StringTokenizer st = new StringTokenizer(in.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 4; i++) {
            operCount[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0);

        System.out.println(max);
        System.out.println(min);

        in.close();
    }

    private static void backTracking(int depth) {
        if (depth == N - 1) {
            int result = calculate();
            if (result > max) {
                max = result;
            }

            if (result < min) {
                min = result;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (operCount[i] != 0) {
                selectOper[depth] = oper[i];
                operCount[i] -= 1;
                backTracking(depth + 1);
                operCount[i] += 1;
            }
        }
    }

    private static int calculate() {
        int result = numbers[0];

        for (int i = 0; i < N - 1; i++) {
            switch (selectOper[i]) {
                case '+':
                    result += numbers[i + 1];
                    break;
                case '-':
                    result -= numbers[i + 1];
                    break;
                case '*':
                    result *= numbers[i + 1];
                    break;
                case '/':
                    result /= numbers[i + 1];
                    break;
            }
        }

        return result;
    }
}