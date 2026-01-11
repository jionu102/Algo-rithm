import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int bits = 0;
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            char c = op.charAt(0);

            if (c == 'a') {
                if (op.charAt(1) == 'd') {
                    bits |= (1 << Integer.parseInt(st.nextToken()));
                } else {
                    bits = (1 << 21) - 1;
                }
            } else if (c == 'r') {
                bits &= ~(1 << Integer.parseInt(st.nextToken()));
            } else if (c == 'c') {
                sb.append((bits >> Integer.parseInt(st.nextToken())) & 1).append('\n');
            } else if (c == 't') {
                bits ^= (1 << Integer.parseInt(st.nextToken()));
            } else {
                bits = 0;
            }
        }
        System.out.print(sb);
    }
}