import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;

    private static int[] dy = new int[]{-1, 1, 0, 0};
    private static int[] dx = new int[]{0, 0, -1, 1};

    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];

        int sy = 0;
        int sx = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) {
                    sy = i;
                    sx = j;
                }
            }
        }

        visited = new int[n][m];
        bfs(graph, sy, sx);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && graph[i][j] == 1) {
                    visited[i][j] = -1;
                }
                sb.append(visited[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);

        in.close();
    }

    private static void bfs(int[][] graph, int sy, int sx) {
        Queue<int[]> queue = new ArrayDeque<>();
        int count = 0;
        queue.offer(new int[]{sy, sx, count});

        while (!queue.isEmpty()) {
            int[] parts = queue.poll();
            int ny = parts[0];
            int nx = parts[1];
            int tempCount = parts[2] + 1;

            for (int i = 0; i < 4; i++) {
                int y = ny + dy[i];
                int x = nx + dx[i];

                if (y >= 0 && y < n && x >= 0 && x < m && (y != sy || x != sx)) {
                    if (graph[y][x] == 1 && visited[y][x] == 0) {
                        visited[y][x] = tempCount;
                        queue.offer(new int[]{y, x, tempCount});
                    }
                }
            }
        }
    }
}