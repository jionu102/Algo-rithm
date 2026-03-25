import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;

    private static int[] dy = new int[] {-1, 1, 0, 0};
    private static int[] dx = new int[] {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] graph = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            graph[i] = str.toCharArray();
        }

        int count = bfs(graph, 0, 0);
        System.out.println(count);

        in.close();
    }

    private static int bfs(char[][] graph, int sy, int sx) {
        boolean[][] visited = new boolean[N][M];
        visited[sy][sx] = true;

        int count = 1;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sy, sx, count});

        while (!queue.isEmpty()) {
            int[] yx = queue.poll();
            int y = yx[0];
            int x = yx[1];
            int tempCount = yx[2];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M && graph[ny][nx] != '0' && !visited[ny][nx]) {
                    if (ny == N - 1 && nx == M - 1) {
                        return tempCount + 1;
                    }
                    visited[ny][nx] = true;
                    queue.offer(new int[] {ny, nx, tempCount + 1});
                }
            }
        }
        return -1;
    }

}