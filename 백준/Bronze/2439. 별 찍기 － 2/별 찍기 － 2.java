import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n < 1 || n > 100) n = in.nextInt();

        for(int i = 1; i<=n; i++){
            for(int j = n; j > i; j--) System.out.print(" ");

            for(int k = 0; k < i; k++) {
                if (k == i-1) System.out.println("*");
                else System.out.print("*");
            }
        }
        in.close();
    }
}
