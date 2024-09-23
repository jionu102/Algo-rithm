import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int M = in.nextInt();
        int N = in.nextInt();

        List<Integer> list = new ArrayList<>();

        for(int i = M; i <= N; i++){
            if(isPrime(i)){
                list.add(i);
            }
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }

        in.close();
    }

    static boolean isPrime(int n){
        if(n < 2) return false;
        if(n==2) return true;

        int num = (int)Math.pow(n, 0.5);
        for(int i = 2; i <= num; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
