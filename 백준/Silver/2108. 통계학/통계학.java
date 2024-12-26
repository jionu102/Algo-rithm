import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] arr = new int[N];

        int count;
        int[] frequency = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        int index = 0;
        frequency[0]++;
        for(int i = 1; i < N; i++) {
            if (arr[i-1] != arr[i]) {
                index = i;
                frequency[index]++;
            }
            if (arr[i-1] == arr[i]) {
                frequency[index]++;
            }
        }

        int max_index = Arrays.stream(frequency).max().getAsInt();
        List<Integer> max = new ArrayList<>();
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] == max_index) {
                max.add(arr[i]);
            }
        }

        Collections.sort(max);

        System.out.println(
                Math.round((float) Arrays.stream(arr).sum() / arr.length)
        );

        System.out.println(
            arr[arr.length / 2]
        );

        System.out.println(
            max.size() > 1 ? max.get(1) : max.get(0)
        );

        System.out.println(
                arr[N-1] - arr[0]
        );
    }
}
