import java.util.*;

public class Main {
    private static final Map<String, Integer> wears = new HashMap<>();
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = in.nextInt();
        in.nextLine();

        for (int i = 0; i < testCases; i++) {
            mapInit();
            int cases = calculateCases();
            System.out.println(cases);
        }
        in.close();
    }

    public static void mapInit() {
        wears.clear();
        int wearNumber = in.nextInt();
        in.nextLine();
        for (int j = 0; j < wearNumber; j++) {
            in.next();
            String key = in.nextLine();
            if (!wears.containsKey(key)) {
                wears.put(key, 2);
            } else {
                wears.put(key, wears.get(key) + 1);
            }
        }
    }

    public static int calculateCases() {
        int cases = 1;
        for (Integer values : wears.values()) {
            cases *= values;
        }
        return cases - 1;
    }
}
