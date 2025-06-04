import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Long> map = new HashMap<>();
        Map<Long, String> reverseMap = new HashMap<>();

        int N = in.nextInt();
        int M = in.nextInt();
        in.nextLine();

        for (int i = 1; i < N + 1; i++) {
            String name = in.nextLine();
            map.put(name, (long)i);
            reverseMap.put((long)i, name);
        }

        for (int i = 0; i < M; i++) {
            String s = in.nextLine();
            try {
                Long l = Long.parseLong(s);
                System.out.println(reverseMap.get(l));
            } catch (NumberFormatException e) {
                System.out.println(map.get(s));
            }
        }
    }
}
