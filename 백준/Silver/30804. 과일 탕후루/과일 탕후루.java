import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int[] fruits = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> cache = new HashMap<>();
        int right = 0;
        int left = 0;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            right = i;
            cache.put(fruits[right], cache.getOrDefault(fruits[right], 0) + 1);

            while (cache.size() > 2) {
                cache.put(fruits[left], cache.get(fruits[left]) - 1);
                if (cache.get(fruits[left]) == 0) {
                    cache.remove(fruits[left]);
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);

        in.close();
    }
}