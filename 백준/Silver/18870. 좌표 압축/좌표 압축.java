import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();
        in.nextLine();

        List<Integer> original = new ArrayList<>();
        Map<Integer, Integer> convertMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            original.add(in.nextInt());
        }

        List<Integer> copy = new ArrayList<>(original);
        copy.sort(Comparator.comparing(Integer::intValue));

        int value = 0;
        for (Integer integer : copy) {
            if (!convertMap.containsKey(integer)) {
                convertMap.put(integer, value++);
            }
        }

        for (int i = 0; i < original.size(); i++) {
            sb.append(convertMap.get(original.get(i))).append(" ");
        }

        System.out.println(sb);

        in.close();
    }
}