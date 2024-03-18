import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int[] arr = new int[26];
        for(int i = 0; i < 26; i++)
            arr[i] = -1;

        s = s.toUpperCase();
        for(int i = 0 ; i < s.length(); i++){
            if(arr[s.charAt(i) - 65] == -1)
                arr[s.charAt(i) - 65] = i;
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
        in.close();
    }
}
