import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();
        in.nextLine();

        int[] arr = new int[2];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            int result = a[0] - b[0];
            if (result == 0) {
                result = a[1] - b[1];
            }
            return result;
        });

        for (int i = 0; i < N; i++) {
            int originalNum = in.nextInt();
            if (originalNum != 0) {
                in.nextLine();
                int absNum = Math.abs(originalNum);
                queue.offer(new int[]{absNum, originalNum});
            } else {
                int result = !queue.isEmpty() ? queue.poll()[1] : 0;
                sb.append(result).append('\n');
            }
        }

        System.out.println(sb);

        in.close();
    }
}