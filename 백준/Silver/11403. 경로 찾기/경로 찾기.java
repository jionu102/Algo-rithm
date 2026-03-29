import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        int[][] graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            for (int j = 0; st.hasMoreTokens(); j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            bfs(graph, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int num : visited[i]) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);

        in.close();
    }

    private static void bfs(int[][] graph, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int j = 0; j < N; j++) {
                if (graph[node][j] == 1 && visited[start][j] == 0) {
                    visited[start][j] = 1;
                    queue.offer(j);
                }
            }
        }
    }
}