import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int num;
        boolean b;
        int cnt = 0;

        for(int i = 0; i < N; i++){
            num = in.nextInt();

            if(num == 1) continue;
            else if(num == 2 || num == 3) cnt++;
            else{
                b = true;
                for (int j = 2; j <= Math.sqrt(num); j++) {
                    if (num % j == 0){
                        b = false;
                        break;
                    }
                }
                if(b){
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        in.close();
    }
}
