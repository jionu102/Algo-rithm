import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] s = new String[4];

        int result;

        for(int i = 0; i < 3; i++){
            s[i] = in.nextLine();
            if(!(s[i].equals("Fizz") || s[i].equals("Buzz") || s[i].equals("FizzBuzz"))){
                result = Integer.parseInt(s[i]) + 3 - i;
                if(result % 3 == 0 && result % 5 != 0){
                    s[3] = "Fizz";
                }else if(result % 5 == 0 && result % 3 != 0){
                    s[3] = "Buzz";
                }else if(result % 5 == 0 && result % 3 == 0){
                    s[3] = "FizzBuzz";
                } else{
                    s[3] = Integer.toString(result);
                }
            }
        }

        System.out.println(s[3]);

        in.close();
    }
}
