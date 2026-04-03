import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        M = Integer.parseInt(in.readLine());

        List<int[]>[] graph = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[startNode].add(new int[]{endNode, cost});
        }

        int[] dist = new int[N + 1];

        StringTokenizer st = new StringTokenizer(in.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bfs(graph, dist, start, end);

        System.out.println(dist[end]);

        in.close();
    }

    private static void bfs(List<int[]>[] graph, int[] dist, int start, int end) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] parts = queue.poll();
            int node = parts[0];
            int cost = parts[1];

            if (node == end) {
                return;
            }

            if (cost > dist[node]) {
                continue;
            }

            for (int[] target : graph[node]) {
                int nextNode = target[0];
                int nextCost = target[1];

                if (dist[nextNode] > nextCost + cost) {
                    dist[nextNode] = nextCost + cost;
                    queue.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
    }
}