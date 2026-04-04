import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();

        while (T > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            List<int[]>[] graph = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            int ghCost = 0;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(in.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                graph[start].add(new int[]{end, w});
                graph[end].add(new int[]{start, w});

                if ((start == g && end == h) || (start == h && end == g)) {
                    ghCost = w;
                }
            }

            int[] destination = new int[t];
            for (int i = 0; i < t; i++) {
                destination[i] = Integer.parseInt(in.readLine());
            }


            int[] distS = new int[n + 1];
            Arrays.fill(distS, Integer.MAX_VALUE);
            bfs(graph, distS, s);

            int[] distG = new int[n + 1];
            Arrays.fill(distG, Integer.MAX_VALUE);
            bfs(graph, distG, g);

            int[] distH = new int[n + 1];
            Arrays.fill(distH, Integer.MAX_VALUE);
            bfs(graph, distH, h);

            List<Integer> result = new ArrayList<>();
            for (int num : destination) {
                if ((distS[num] == distG[num] + ghCost + distH[s]) ||
                        (distS[num] == distH[num] + ghCost + distG[s])) {
                    result.add(num);
                }
            }

            result.sort(Comparator.comparing(Integer::intValue));
            for (int num : result) {
                sb.append(num).append(' ');
            }
            sb.append('\n');

            T--;
        }

        System.out.println(sb);

        in.close();
    }

    private static void bfs(List<int[]>[] graph, int[] dist, int start) {
        dist[start] = 0;

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] parts = queue.poll();
            int node = parts[0];
            int cost = parts[1];

            if (cost > dist[node]) {
                continue;
            }

            for (int[] target : graph[node]) {
                int nextNode = target[0];
                int nextCost = target[1];

                if (dist[nextNode] > cost + nextCost) {
                    dist[nextNode] = cost + nextCost;
                    queue.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
    }
}