import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        List<Integer> cache = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            arr[i] = in.nextInt();
        }

        for(int i = 0; i< 10; i++){
            arr[i] %= 42;
            if(!cache.contains(arr[i])) cache.add(arr[i]);
        }
        System.out.println(cache.size());
        in.close();
    }

}