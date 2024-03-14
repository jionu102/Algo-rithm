import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s;
        int cnt = 1, total = 0;
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            s = in.next().toUpperCase();

            for(int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'O') total += cnt++;
                else cnt = 1;
            }
            System.out.println(total);
            cnt = 1; total = 0;
        }
        in.close();
    }
}