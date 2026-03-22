import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        int count = 0;

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                dfs(graph, i);
                count++;
            }
        }

        System.out.println(count);
        in.close();
    }

    public static void dfs(List<Integer>[] graph, int start) {
            visited[start] = true;
            
            for (int neighbor : graph[start]) {
                if (!visited[neighbor]) {
                    dfs(graph, neighbor);
                }
            }
    }
}