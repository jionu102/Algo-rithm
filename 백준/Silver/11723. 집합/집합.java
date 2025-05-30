import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int S = 0;

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int number = -1;

            switch (ch) {
                case 'a':
                    if (st.hasMoreTokens()) {
                        S = S | (1 << Integer.parseInt(st.nextToken()));
                    } else {
                        S = (1 << 21) - 2;
                    }
                    break;
                case 'r' :
                    S = S & ~(1 << Integer.parseInt(st.nextToken()));
                    break;
                case 'c' :
                    int x = (S & (1 << Integer.parseInt(st.nextToken()))) != 0 ? 1 : 0;
                    sb.append(x).append("\n");
                    break;
                case 't':
                    S = S ^ (1 << Integer.parseInt(st.nextToken()));
                    break;
                case 'e' :
                    S = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}
