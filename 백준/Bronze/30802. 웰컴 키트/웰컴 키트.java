import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] cnt = new int[6];
        int[] size = new int[6];
        for(int i = 0; i < 6; i++){
            size[i] = in.nextInt();
        }
        int T = in.nextInt();
        int P = in.nextInt();
        int Tsum = 0;
        int pack = N / P;
        int indi = N % P;

        for(int i = 0; i < 6; i++){
            Tsum += TS(T, size[i]);
        }

        System.out.println(Tsum);
        System.out.println(pack + " " + indi);
        in.close();
    }

    public static int TS(int T, int S){
        int a = S%T;
        int cnt = S/T;
        if(a > 0) {
            return ++cnt;
        }
        else{
            return cnt;
        }
    }
}
