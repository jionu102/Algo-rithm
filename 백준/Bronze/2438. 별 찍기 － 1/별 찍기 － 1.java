import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        while(n<1 || n>100) n = in.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++) System.out.print("*");
            System.out.println();
        }
        in.close();
    }
}