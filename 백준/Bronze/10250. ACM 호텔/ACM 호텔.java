import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(), h, w, n;
        int[] arr = new int[t];

        for(int i = 0; i < t; i++){
            h = in.nextInt();
            w = in.nextInt();
            n = in.nextInt();

            if(n % h == 0){
                System.out.println(h * 100 + n / h);
            }
            else {
                System.out.println(n % h * 100 + (n / h + 1));
            }
        }
        in.close();
    }
}
