import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static boolean[][] visited;

    private static int[] dy = new int[]{-1, 1, 0, 0, -1, -1, 1, 1};
    private static int[] dx = new int[]{0, 0, -1, 1, -1, 1, -1, 1};

    private static int w;
    private static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            visited = new boolean[h][w];
            int[][] arr = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        dfs(arr, i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }

        System.out.println(sb);

        in.close();
    }

    private static void dfs(int[][] arr, int i, int j) {
        visited[i][j] = true;

        for (int z = 0; z < 8; z++) {
            int ny = i + dy[z];
            int nx = j + dx[z];
            if (ny >= 0 && ny < h && nx >= 0 && nx < w) {
                if (arr[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(arr, ny, nx);
                }
            }
        }
    }
}