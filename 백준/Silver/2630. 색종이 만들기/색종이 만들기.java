import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] rectangle;
    private static int white = 0;
    private static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        rectangle = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                rectangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideConquer(0, N - 1, 0, N - 1);

        System.out.println(white);
        System.out.println(blue);

        br.close();
    }

    private static void divideConquer(int xStart, int xEnd, int yStart, int yEnd) {
        if (isAllBlue(xStart, xEnd, yStart, yEnd)) {
            blue++;
        } else if (isAllWhite(xStart, xEnd, yStart, yEnd)) {
            white++;
        } else {
            int xHalf = (xStart + xEnd) / 2;
            int yHalf = (yStart + yEnd) / 2;
            divideConquer(xStart, xHalf, yStart, yHalf);
            divideConquer(xHalf + 1, xEnd, yStart, yHalf);
            divideConquer(xStart, xHalf, yHalf + 1, yEnd);
            divideConquer(xHalf + 1, xEnd, yHalf + 1, yEnd);
        }
    }

    private static boolean isAllBlue(int xStart, int xEnd, int yStart, int yEnd) {
        for (int i = yStart; i <= yEnd; i++) {
            for (int j = xStart; j <= xEnd; j++) {
                if (rectangle[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isAllWhite(int xStart, int xEnd, int yStart, int yEnd) {
        for (int i = yStart; i <= yEnd; i++) {
            for (int j = xStart; j <= xEnd; j++) {
                if (rectangle[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
