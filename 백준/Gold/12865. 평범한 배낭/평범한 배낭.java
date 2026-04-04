import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ----- DP -----
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            arr[i][0] = W;
            arr[i][1] = V;
        }

        int[] memo = new int[K + 1];

        for (int i = 0; i < N; i++) {
            int w = arr[i][0];
            int v = arr[i][1];

            for (int j = K; j >= w; j--) {
                memo[j] = Math.max(memo[j], memo[j - w] + v);
            }
        }

        System.out.println(memo[K]);

        in.close();
    }
}