import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static final StringBuilder sb = new StringBuilder();

    private static int node;
    private static int edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken()) + 1;
        edge = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        graph = new ArrayList[node];
        for (int i = 0; i < node; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[node];

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            graph[y].add(x);
            graph[x].add(y);
        }

        for (int i = 1; i < node; i++) {
            Collections.sort(graph[i]);
        }

        dfs(startNode);
        sb.append("\n");
        visited = new boolean[node];
        bfs(startNode);

        System.out.println(sb);

        br.close();
    }

    private static void bfs(int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(y);
        sb.append(y).append(" ");
        visited[y] = true;

        while (!queue.isEmpty()) {
            int cy = queue.poll();

            for (int i : graph[cy]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }

    private static void dfs(int y) {
        sb.append(y).append(" ");
        visited[y] = true;

        for (int i : graph[y]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
