import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int sum = 0;
        int O = -1;

        for(int i = 0; i < N; i++){
            String s = Integer.toString(i);
            for(int j = 0; j < s.length(); j++){
                sum += Integer.parseInt(s.substring(j, j+1));
            }
            O = sum + i;
            if(O == N){
                break;
            }else{
                sum = 0;
                O = -1;
            }
        }

        if(O == -1) {
            System.out.println("0");
        } else{
            System.out.println(O - sum);
        }
        in.close();
    }
}