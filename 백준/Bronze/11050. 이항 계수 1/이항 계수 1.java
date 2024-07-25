import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long N = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());
        System.out.print(factorial(N) / (factorial(K) * factorial(N - K)));
    }

    public static long factorial(long num){
        if(num <= 1){
            return 1;
        }
        return num * factorial(num - 1);
    }
}
