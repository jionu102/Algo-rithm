import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        int target_index;

        for(int i = 0; i < T; i++) {
            int N = in.nextInt();
            int M = in.nextInt();

            LinkedList<int[]> importance = new LinkedList<>();
            int cnt = 0;

            for(int j = 0; j < N; j++) {
                importance.add(new int[] { j, in.nextInt() });
            }

            while (!importance.isEmpty()) {
                int[] front = importance.poll();
                boolean isMax = true;

                for (int j = 0; j < importance.size(); j++) {
                    if (front[1] < importance.get(j)[1]) {
                        importance.offer(front);
                        for (int k = 0; k < j; k++) {
                            importance.offer(importance.poll());
                        }
                        isMax = false;
                        break;
                    }
                }
                if (!isMax) {
                    continue;
                }

                cnt++;
                if(front[0] == M) {
                    break;
                }
            }
            System.out.println(cnt);
        }
    }
}
