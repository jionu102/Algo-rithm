import java.util.*;

public class Main {

    private static final char[] dx = new char[] {'+', '-', '*'};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();
        in.nextLine();

        int time;
        if (N == K) {
            time = 0;
        } else {
            time = bfs(N, K);
        }

        System.out.println(time);

        in.close();
    }

    public static int bfs(int N, int K) {
        int maxNode = 100000;
        int minNode = 0;

        boolean[] visited = new boolean[maxNode + 1];
        visited[N] = true;

        int time = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {N, time});

        while (!queue.isEmpty()) {
            int[] parts = queue.poll();
            int node = parts[0];
            time = parts[1];

            for (int i = 0; i < 3; i++) {
                int nextNode;

                switch (dx[i]) {
                    case '+':
                        nextNode = node + 1;
                        break;
                    case '-':
                        nextNode = node - 1;
                        break;
                    default:
                        nextNode = node * 2;
                        break;
                };

                if (nextNode >= minNode && nextNode <= maxNode && !visited[nextNode]) {
                    if (nextNode == K) {
                        return time + 1;
                    }
                    visited[nextNode] = true;
                    queue.offer(new int[] {nextNode, time + 1});
                }
            }
        }

        return -1;
    }
}