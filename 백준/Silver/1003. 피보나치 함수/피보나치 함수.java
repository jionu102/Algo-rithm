import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Integer, Integer> cache0 = new HashMap<>();
    private static final Map<Integer, Integer> cache1 = new HashMap<>();

    public static void main(String[] args) {
        cache0.put(0, 1);
        cache0.put(1, 0);
        cache1.put(0, 0);
        cache1.put(1, 1);

        Scanner in = new Scanner(System.in);

        int testCase = in.nextInt();
        in.nextLine();

        for (int i = 0; i < testCase; i++) {
            int target = in.nextInt();
            in.nextLine();
            System.out.println(find0(target) + " " + find1(target));
        }

        in.close();
    }

    private static int find0 (int target) {
        if (cache0.containsKey(target)) {
            return cache0.get(target);
        } else {
            int result = find0(target - 1) + find0(target - 2);
            cache0.put(target, result);
            return result;
        }
    }

    private static int find1(int target) {
        if (cache1.containsKey(target)) {
            return cache1.get(target);
        } else {
            int result = find1(target - 1) + find1(target - 2);
            cache1.put(target, result);
            return result;
        }
    }
}