import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long r = 1;
        long M = 1234567891;
        long H;

        int N = in.nextInt();
        in.nextLine();
        String s = in.nextLine();

        long sum = 0;

        for(int i = 0; i < N; i++){
            sum += r * ((long)s.charAt(i) - 96);
            r = (r * 31) % M;
        }

        H = sum;

        System.out.println(H);
        in.close();
    }
}
