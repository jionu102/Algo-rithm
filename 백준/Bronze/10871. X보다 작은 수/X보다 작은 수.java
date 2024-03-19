import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int X = in.nextInt();
        int[] arr = new int[N];
        List<Integer> cache = new ArrayList<>();

        for(int i = 0; i < N; i++){
            arr[i] = in.nextInt();
            if(arr[i] < X) cache.add(arr[i]);
        }

        for (Integer integer : cache) {
            System.out.print(integer + " ");
        }
        
        in.close();
    }

}
