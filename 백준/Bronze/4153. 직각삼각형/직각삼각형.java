import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c;
        boolean tf;

        while(true) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();

            if(a == 0 && b == 0 && c == 0){
                break;
            }

            tf = triangle(a, b, c);

            if(tf){
                System.out.println("right");
            }
            else if(!tf){
                System.out.println("wrong");
            }
        }
        scanner.close();
    }

    public static boolean triangle(int a, int b, int c){
        a = a * a;
        b = b * b;
        c = c * c;
        return a == b + c || b == a + c || c == a + b;
    }
}
