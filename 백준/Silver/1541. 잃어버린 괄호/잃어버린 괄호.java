import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String expression = in.readLine();
        
        String[] parts = expression.split("-");
        
        int result = 0;
        for (int i = 0; i < parts.length; i++) {
            int sum = 0;
            String[] nums = parts[i].split("\\+");
            for (String num : nums) {
                if (!num.isEmpty()) {
                    sum += Integer.parseInt(num);
                }
            }
            
            if (i == 0) {
                result += sum; 
            } else {
                result -= sum;
            }
        }
        
        System.out.println(result);
    }
}