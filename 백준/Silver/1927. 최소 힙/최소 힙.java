import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        PriorityQueue<Integer> qu = new PriorityQueue<>(N, Comparator.comparing(Integer::intValue));
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {

            int x = in.nextInt();
            in.nextLine();

            if (x > 0) {
                qu.offer(x);
            } else {
                sb.append(
                        Optional.ofNullable(qu.poll()).orElse(0)
                ).append("\n");
            }
        }

        System.out.println(sb);

        in.close();
    }
}
