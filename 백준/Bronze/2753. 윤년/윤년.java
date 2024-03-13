import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if((n % 4 == 0 && n % 100 != 0)||(n % 400 == 0))
            System.out.println(1);
        else
            System.out.println(0);
        in.close();
    }

}