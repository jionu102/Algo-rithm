import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int width;
    private static int height;

    private static List<Integer>[] garden;
    private static boolean[][] visited;
    private static int count;

    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            int cabbage = Integer.parseInt(st.nextToken());

            visited = new boolean[height][width];
            garden = new ArrayList[height];

            for (int i = 0; i < height; i++) {
                garden[i] = new ArrayList<>();
            }

            for (int i = 0; i < cabbage; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                garden[y].add(x);
            }

            for (int i = 0; i < height; i++) {
                for (int j : garden[i]) {
                    if (!visited[i][j]) {
                        checkWorm(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

        br.close();
    }

    private static void checkWorm(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()) {
            int cy = queue.peek()[0];
            int cx = queue.peek()[1];
            queue.poll();

            if (isEffectiveRange(cy, cx) && !visited[cy][cx] && garden[cy].contains(cx)) {
                visited[cy][cx] = true;
                for (int i = 0; i < 4; i++) {
                    int ny = cy + dy[i];
                    int nx = cx + dx[i];
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }

    private static boolean isEffectiveRange(int y, int x) {
        return (x >= 0 && x < width) && (y >= 0 && y < height);
    }
}
