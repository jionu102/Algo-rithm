import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<long[]>[] graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[startNode].add(new long[]{endNode, cost});
            graph[endNode].add(new long[]{startNode, cost});
        }

        long[][] dist = new long[N + 1][K + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }
        bfs(graph, dist, 1, K);

        long minCost = Long.MAX_VALUE;
        for (int i = 0; i < K + 1; i++) {
            if (dist[N][i] < minCost) {
                minCost = dist[N][i];
            }
        }

        System.out.println(minCost);

        in.close();
    }

    private static void bfs(List<long[]>[] graph, long[][] dist, int start, int K) {
        dist[start][0] = 0;

        Queue<long[]> queue = new PriorityQueue<>((a, b) -> Math.toIntExact(a[1] - b[1]));
        queue.offer(new long[]{start, 0, 0});

        while (!queue.isEmpty()) {
            long[] parts = queue.poll();
            int node = (int) parts[0];
            long cost = parts[1];
            int k = (int) parts[2];

            if (cost > dist[node][k]) {
                continue;
            }

            for (long[] target : graph[node]) {
                int nextNode = (int) target[0];
                long nextCost = target[1];
                if (cost + nextCost < dist[nextNode][k]) {
                    dist[nextNode][k] = nextCost + cost;
                    queue.offer(new long[]{nextNode, dist[nextNode][k], k});
                }

                nextCost = 0;
                if (k < K && cost + nextCost < dist[nextNode][k + 1]) {
                    dist[nextNode][k + 1] = nextCost + cost;
                    queue.offer(new long[]{nextNode, dist[nextNode][k + 1], k + 1});
                }
            }
        }
    }
}