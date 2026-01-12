import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int testCases = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int[] prefix = new int[N + 1];
        prefix[0] = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < testCases; i++) {
            st = new StringTokenizer(br.readLine());
            int lower = Integer.parseInt(st.nextToken());
            int upper = Integer.parseInt(st.nextToken());

            int sum = prefix[upper] - prefix[lower - 1];
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
