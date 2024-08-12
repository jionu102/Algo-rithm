import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.nextLine();
        String s;

        for(int i = 0; i < N; i ++){
            s = in.nextLine();
            System.out.println(VPS(s));
        }

        in.close();
    }

    private static String VPS(String s){
        Stack<Character> stack = new Stack<>();
        String YN = "YES";

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                if(stack.empty()){
                    YN = "NO";
                    break;
                }else if(stack.peek() == '('){
                    stack.pop();
                }
            }
        }

        if(!stack.empty()) YN = "NO";

        return YN;
    }
}
