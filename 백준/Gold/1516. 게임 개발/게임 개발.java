import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 1516 위상 정렬
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        List<Integer>[] graph = new ArrayList[N + 1];
        int[] times = new int[N + 1];
        int[] inDegree = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int time = Integer.parseInt(st.nextToken());
            times[i] = time;

            while (st.hasMoreTokens()) {
                int start = Integer.parseInt(st.nextToken());

                if (start == -1) {
                    break;
                }

                graph[start].add(i);
                inDegree[i]++;
            }
        }

        int[] resultTime = new int[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i < N + 1; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                resultTime[i] = times[i];
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int num : graph[now]) {
                inDegree[num]--;

                resultTime[num] = Math.max(resultTime[num], resultTime[now] + times[num]);

                if (inDegree[num] == 0) {
                    queue.offer(num);
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            System.out.println(resultTime[i]);
        }

        in.close();
    }
}