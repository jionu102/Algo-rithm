import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int h = in.nextInt(), m  = in.nextInt();
        if(m - 45 < 0){
            h--;
            if(h < 0) h = 23;
            m += 15;
        }
        else{
            m -= 45;
        }
        System.out.println(h + " " + m);
        in.close();
    }

}