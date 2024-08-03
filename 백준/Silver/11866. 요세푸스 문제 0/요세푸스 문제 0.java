import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        List<Integer> list = new ArrayList<>();
        List<Integer> cacheList = new ArrayList<>();

        int cnt = K - 1;

        for(int i = 1; i <= N; i++){
            list.add(i);
        }

        while(true){
            cacheList.add(list.get(cnt));
            list.remove(cnt);
            if(list.isEmpty()) break;
            cnt = (cnt + K - 1) % list.size();
        }

        System.out.print("<");

        for(int i = 0; i < N; i++){
            if(i == N-1) System.out.print(cacheList.get(i) + ">");
            else System.out.print(cacheList.get(i) + ", ");
        }

        in.close();
    }
}
