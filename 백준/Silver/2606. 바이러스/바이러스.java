import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int number = in.nextInt();
        int coupleNumber = in.nextInt();

        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[number + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < coupleNumber; i++) {
            int node = in.nextInt();
            int adjacent = in.nextInt();
            graph[node].add(adjacent);
            graph[adjacent].add(node);
        }

        System.out.println(bfsSearch(graph, 1, new boolean[number + 1]));
    }

    public static int bfsSearch(List<Integer>[] graph, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Integer adjacent : graph[node]) {
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    count++;
                    queue.add(adjacent);
                }
            }
        }
        return count;
    }
}
