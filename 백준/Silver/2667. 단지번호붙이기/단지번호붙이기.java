import java.util.*;

public class Main {

    private static int N;
    private static final int[] dy = new int[]{-1, 1, 0, 0};
    private static final int[] dx = new int[]{0, 0, -1, 1};
    private static int count;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = in.nextInt();
        in.nextLine();

        char[][] graph = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = in.nextLine();
            graph[i] = str.toCharArray();
        }

        visited = new boolean[N][N];
        List<Integer> countList = new ArrayList<>();

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (graph[y][x] != '0' && !visited[y][x]) {
                    count = 1;
                    dfs(graph, y, x);
                    countList.add(count);
                }
            }
        }

        sb.append(countList.size()).append('\n');
        countList.stream()
                .sorted(Comparator.comparing(Integer::intValue))
                .forEach(num -> sb.append(num).append('\n'));

        System.out.println(sb);

        in.close();
    }

    private static void dfs(char[][] graph, int sy, int sx) {
        visited[sy][sx] = true;

        for (int i = 0; i < 4; i++) {
            int ny = sy + dy[i];
            int nx = sx + dx[i];

            if (ny >= 0 && ny < N && nx >= 0 && nx < N && graph[ny][nx] != '0' && !visited[ny][nx]) {
                count++;
                dfs(graph, ny, nx);
            }
        }
    }
}