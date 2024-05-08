import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cnt = 0;
        String s;

        while(n > 0){
            cnt++;
            s = Integer.toString(cnt);
            if(s.contains("666")){
                n--;
            }
        }
        System.out.println(cnt);
        in.close();
    }
}