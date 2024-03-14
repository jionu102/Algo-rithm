import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s;
        int[] arr = new int[8];

        for(int i = 0; i<8; i++){
            arr[i] = in.nextInt();
        }

        int[] ascend = new int[]{1,2,3,4,5,6,7,8};
        int[] descend = new int[]{8,7,6,5,4,3,2,1};

        if(arrCom(arr,ascend)) System.out.println("ascending");

        else if(arrCom(arr,descend)) System.out.println("descending");

        else System.out.println("mixed");

        in.close();
    }
    private static boolean arrCom(int[] arr, int[] arr1){
        for(int i = 0; i < 8; i++){
            if(arr[i] != arr1[i]) return false;
        }
        return true;
    }
}