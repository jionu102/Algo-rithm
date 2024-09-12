import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];

        double exeption = (double)(N) * 15.0 / 100.0;
        exeption = Math.round(exeption);

        int sum = 0;

        for(int i = 0; i < N; i ++){
            arr[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(arr);

        for(int i = (int)exeption; i < arr.length - (int)exeption; i++){
            sum += arr[i];
        }
        System.out.println((int)Math.round((double)sum / (arr.length - exeption * 2)));

        in.close();
    }
}
