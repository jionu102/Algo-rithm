import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        int num = 0;

        for(int i = 0; i< 5; i++){
            arr[i] = in.nextInt();
        }
        if(arrVerification(arr)){
            for(int i = 0; i < 5; i++){
                num += arr[i] * arr[i];
            }
            System.out.println(num%10);
            in.close();
        }
    }

    private static boolean arrVerification(int[] arr){
        for(int i = 0; i < 5; i++){
            if(arr[i] > 9 || arr[i] < 0) return false;
        }
        return true;
    }
}