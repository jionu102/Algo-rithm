import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            sb.append(in.readLine());
        }

        List<Integer>[] graph = new ArrayList[N * M];

        for (int i = 0; i < N * M; i++) {
            graph[i] = new ArrayList<>();

            int[] nodes = new int[]{i - 1, i - M, i + 1, i + M};
            boolean[] valid = new boolean[] {
                    i % M != 0,
                    i / M > 0,
                    i % M < M - 1,
                    i / M < N - 1
            };
            for (int j = 0; j < 4; j++) {
                if (valid[j] && sb.charAt(nodes[j]) != 'X') {
                    graph[i].add(nodes[j]);
                }
            }
        }

        int count = bfs(graph, sb.indexOf("I"));

        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }

        in.close();
    }

    public static int bfs(List<Integer>[] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        visited[start] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        int count = 0;

        while(!queue.isEmpty()) {
            int index = queue.poll();

            for (int num : graph[index]) {
                if (!visited[num]) {
                    if (sb.charAt(num) == 'P') {
                        count++;
                    }
                    visited[num] = true;
                    queue.offer(num);
                }
            }
        }

        return count;
    }
}