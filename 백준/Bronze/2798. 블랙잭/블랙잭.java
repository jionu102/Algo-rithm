import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        int[] NA = new int[N];
        int O = 0;
        int max = 0;
        boolean B = false;

        for(int i = 0; i < N; i++){
            NA[i] = in.nextInt();
        }

        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N - 1; j++){
                for(int k = j + 1; k < N; k++){
                    if(k == i || k == j){
                        continue;
                    }
                    O = NA[i] + NA[j] + NA[k];
                    if(O > max && O <= M){
                        max = O;
                    }
                    if(max == M){
                        B = true;
                        break;
                    }
                }
                if(B) break;
            }
            if(B) break;
        }

        System.out.println(max);
        in.close();
    }
}
