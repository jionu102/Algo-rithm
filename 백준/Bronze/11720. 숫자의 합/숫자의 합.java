import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String s = in.next();
        int sum = 0;
        for(int i = 0; i < t; i++){
            int n = s.charAt(i) - '0';
            sum += n;
        }
        System.out.println(sum);
    }
}
