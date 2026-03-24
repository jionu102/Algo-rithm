import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int M;

    private static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N + 1];

        // List 배열 초기화
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        temp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            bfs(graph, i);
        }

        int min = Integer.MAX_VALUE;
        int minUser = 0;

        for (int i = N; i > 0; i--) {
            if (min >= temp[i]) {
                min = temp[i];
                minUser = i;
            }
        }

        System.out.println(minUser);

        in.close();
    }

    public static void bfs(List<Integer>[] graph, int start) {
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;

        int depth = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, depth});


        while (!queue.isEmpty()) {
            int[] parts = queue.poll();
            int node = parts[0];
            depth = parts[1] + 1;

            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    temp[start] += depth;

                    visited[neighbor] = true;
                    queue.offer(new int[] {neighbor, depth});
                }
            }
        }
    }
}