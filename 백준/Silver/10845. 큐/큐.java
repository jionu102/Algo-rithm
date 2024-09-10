import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.nextLine();

        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0; i < N; i++){
            String s = in.nextLine();
            if(s.length() >= 5 && s.charAt(4) == ' '){
                String[] parts = s.split(" ");
                queue.add(Integer.parseInt(parts[1]));
            } else if (s.equals("pop")) {
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else {
                    System.out.println(queue.poll());
                }
            } else if (s.equals("size")) {
                System.out.println(queue.size());
            } else if (s.equals("empty")) {
                if (queue.isEmpty()){
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
            } else if (s.equals("front")) {
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else {
                    System.out.println(queue.peek());
                }
            } else if (s.equals("back")) {
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else {
                    System.out.println(queue.getLast());
                }
            }
        }
        in.close();
    }
}
