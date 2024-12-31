import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        int n = in.nextInt();

        int[] arr = new int[k];
        long max = 0;

        for(int i = 0; i < k; i++) {
            arr[i] = in.nextInt();
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        max++;

        long mid = 0;
        long min = 0;

        while(min < max) {
            long count = 0;
            mid = (max + min) / 2;

            for(int i = 0; i < k; i++) {
                count = count + (arr[i] / mid);
            }

            if (count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);

        in.close();
    }
}
