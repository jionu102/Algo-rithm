import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        System.out.println(s.charAt(n-1));
    }
}
