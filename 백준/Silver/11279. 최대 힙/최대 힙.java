import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> queue = new PriorityQueue<>(
                        Comparator.comparing(Integer::intValue).reversed()
                );

        int testCase = in.nextInt();
        in.nextLine();

        for (int i = 0; i < testCase; i++) {
            int num = in.nextInt();
            in.nextLine();

            if (num == 0) {
                sb.append(!queue.isEmpty() ? queue.poll() : 0).append("\n");
            } else {
                queue.offer(num);
            }
        }

        System.out.println(sb);

        in.close();
    }
}