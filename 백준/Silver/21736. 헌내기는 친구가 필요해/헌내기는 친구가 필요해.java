import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;

    private static final int[] dy = new int[]{1, -1, 0, 0};
    private static final int[] dx = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] graph = new char[N][M];
        int iy = -1;
        int ix = -1;

        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            int iIndex = str.indexOf('I');
            if (iIndex != -1) {
                iy = i;
                ix = iIndex;
            }
            graph[i] = str.toCharArray();
        }

        int count = bfs(graph, iy, ix);
        System.out.println(count > 0 ? count : "TT");

        in.close();
    }

    public static int bfs(char[][] graph, int iy, int ix) {
        boolean[][] visited = new boolean[N][M];
        visited[iy][ix] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{iy, ix});

        int count = 0;

        while (!queue.isEmpty()) {
            int[] yx = queue.poll();
            int y = yx[0];
            int x = yx[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }

                if (graph[ny][nx] != 'X' && !visited[ny][nx]) {
                    if (graph[ny][nx] == 'P') {
                        count++;
                    }

                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }

        return count;
    }
}