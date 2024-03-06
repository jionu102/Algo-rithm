import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        int[] arr = new int[26];
        char ch = '?';

        String s = scanner.nextLine().toUpperCase();

        while(s.length() > 1000000 || !sMethod(s)){
            s = scanner.nextLine().toUpperCase();
        }

        for(int i = 0; i< s.length(); i++) {
            int cnt = s.charAt(i) - 'A';
            arr[cnt]++;
        }

        for(int i = 0; i<26; i++){
            if(max < arr[i]) {
                max = arr[i];
                ch = (char)(i + 'A');
            }
            else if(arr[i] == max) ch = '?';
        }
        System.out.println(ch);
    }
    public static boolean sMethod(String s){
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) < 'A' || s.charAt(i) > 'Z') return false;
        }
        return true;
    }
}