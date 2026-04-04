import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// ----- 위상 정렬 -----
public class Main {

    private static int[] resultTime;
    private static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();

        while (T > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            times = new int[N + 1];
            st = new StringTokenizer(in.readLine());
            for (int i = 1; i < N + 1; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] graph = new ArrayList[N + 1];
            int[] inDegree = new int[N + 1];

            for (int i = 0; i < N + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(in.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph[start].add(end);
                inDegree[end]++;
            }

            int W = Integer.parseInt(in.readLine());

            resultTime = new int[N + 1];
            sort(graph, inDegree, N);

            sb.append(resultTime[W]).append('\n');
            T--;
        }

        System.out.println(sb);

        in.close();
    }

    private static void sort(List<Integer>[] graph, int[] inDegree, int N) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i < N + 1; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                resultTime[i] = times[i];
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                resultTime[next] = Math.max(resultTime[next], resultTime[now] + times[next]);

                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}