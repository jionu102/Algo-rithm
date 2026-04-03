import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] dist;

    private static List<int[]>[] graph;

    private static int V;
    private static int E;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(in.readLine());

        graph = new ArrayList[V + 1];

        // 초기화
        for (int i = 0; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        // 인접 리스트 생성
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());
            int startVertex = Integer.parseInt(st.nextToken());
            int endVertex = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[startVertex].add(new int[]{endVertex, weight});
        }

        bfs(K);

        for (int i = 1; i < V + 1; i++) {
            if (i != K && dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }

        in.close();
    }

    private static void bfs(int start) {
        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] parts = queue.poll();
            int vertex = parts[0];
            int cost = parts[1];

            if (cost > dist[vertex]) {
                continue;
            }

            for (int[] target : graph[vertex]) {
                int nextNode = target[0];
                int nextCost = target[1];
                if (dist[vertex] + nextCost < dist[nextNode]) {
                    dist[nextNode] = dist[vertex] + nextCost;
                    queue.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
    }
}