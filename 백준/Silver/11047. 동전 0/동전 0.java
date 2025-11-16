import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int kind = in.nextInt();
        int targetTotal = in.nextInt();
        int[] coins = new int[kind];

        for (int i = 0; i < kind; i++) {
            coins[i] = in.nextInt();
        }

        int count = 0;

        while (targetTotal > 0) {
            int index = kind - 1;
            while (coins[index] > targetTotal) index--;
            count += (targetTotal / coins[index]);
            targetTotal = targetTotal % coins[index];
        }

        System.out.println(count);
        in.close();
    }
}
