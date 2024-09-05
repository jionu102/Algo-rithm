import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int N = in.nextInt();
        in.nextLine();
        String s = "";

        for(int i = 0; i < N; i++){
            s = in.nextLine();

            if(s.length() > 5 && s.charAt(4) == ' '){
                String[] prams = s.split(" ");
                stack.push(Integer.parseInt(prams[1]));
            } else if (s.equals("top")) {
                if(stack.isEmpty()){
                    System.out.println("-1");
                }else {
                    System.out.println(stack.peek());
                }
            }else if (s.equals("size")){
                System.out.println(stack.size());
            } else if (s.equals("pop")) {
                if(stack.isEmpty()){
                    System.out.println("-1");
                }else{
                    System.out.println(stack.pop());
                }
            } else if (s.equals("empty")) {
                if(stack.isEmpty()){
                    System.out.println("1");
                }else {
                    System.out.println("0");
                }
            }
        }
        in.close();
    }
}
