import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i ++){
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);

        int m = in.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++){
            int key = in.nextInt();

            sb.append(upper(arr, key) - lower(arr, key)).append(" ");
        }

        System.out.println(sb.toString());
        in.close();
    }

    private static int upper(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;

        while(lo < hi){
            int mid = (lo + hi) / 2;

            if(key < arr[mid]){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }

        return lo;
    }

    private static int lower(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;

        while(lo < hi){
            int mid = (lo + hi) / 2;

            if(key <= arr[mid]){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }

        return lo;
    }
}
