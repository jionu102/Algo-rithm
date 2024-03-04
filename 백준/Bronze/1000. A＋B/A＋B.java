import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A,B;

        do {
            A = scanner.nextInt();
            B = scanner.nextInt();
        }while(!(A > 0 && B<10));

        System.out.println(A+B);
        scanner.close();
    }
}