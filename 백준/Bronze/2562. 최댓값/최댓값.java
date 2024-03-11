import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] arr = new int[9];
        int max = 0, index = 0;

        for(int i = 0; i< 9; i++){
            arr[i] = in.nextInt();
        }

        if(arrVal(arr)){
            for(int i = 0; i<9; i++){
                if(max < arr[i]){
                    max = arr[i];
                    index = i+1;
                }
            }
            System.out.println(max);
            System.out.println(index);
        }

        in.close();

    }

    private static boolean arrVal(int[] arr){
        for(int i = 0; i < 9; i++){
            if(arr[i] >= 100 || arr[i] < 1) return false;
        }
        return true;
    }
}
