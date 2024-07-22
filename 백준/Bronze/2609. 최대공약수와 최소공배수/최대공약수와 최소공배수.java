import java.util.Scanner;

public class Main {
    public static int[] gcd = new int[2];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        gcd[0] = in.nextInt();
        gcd[1] = in.nextInt();

        int M = gcd[0];
        int N = gcd[1];

        if(gcd[1] > gcd[0]) swap();

        while(gcd[1] > 0){
            int quotient = gcd[0] / gcd[1];
            gcd[0] = gcd[0] - quotient * gcd[1];
            swap();
        }

        System.out.println(gcd[0]);
        System.out.println((M * N) / gcd[0]);
    }
    public static void swap(){
        int t = gcd[0];
        gcd[0] = gcd[1];
        gcd[1] = t;
    }
}
