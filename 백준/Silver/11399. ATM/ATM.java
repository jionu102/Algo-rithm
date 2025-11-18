import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int peopleNum = in.nextInt();
        in.nextLine();

        int[] withdrawal = new int[peopleNum];
        for (int i = 0; i < peopleNum; i++) {
            withdrawal[i] = in.nextInt();
        }
        in.nextLine();

        Arrays.sort(withdrawal);

        int time = 0;
        int sum = 0;
        for (int i = 0; i < peopleNum; i++) {
            time += withdrawal[i];
            sum += time;
        }

        System.out.println(sum);
        in.close();
    }
}