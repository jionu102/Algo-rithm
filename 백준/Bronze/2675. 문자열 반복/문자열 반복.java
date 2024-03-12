import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0; i < T; i++){

            int R = in.nextInt();
            String s = in.next();

            for(int j = 0; j < s.length(); j++){
                for(int k = 0; k < R; k++){
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }
        in.close();
    }
}
