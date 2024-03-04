import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A,B;

        while(true) {
            A = scanner.nextInt(); B = scanner.nextInt();
            if(A>0 && B<10) break;
        }
        System.out.println(A-B);
        scanner.close();
    }
}