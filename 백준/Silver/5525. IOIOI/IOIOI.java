import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());

        String str = in.readLine();
        StringBuilder patternStr = new StringBuilder();
        patternStr.append("IOI");
        for (int i = 1; i < N; i++) {
            patternStr.append("OI");
        }

        int count = 0;
        int oi = 0;

        for (int i = 0; i < M; i++) {
            if (str.charAt(i) == 'I') {
                if (i + 2 < str.length() && str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I') {
                    oi++;
                } else {
                    oi = 0;
                }
                if (oi >= N) {
                    count++;
                }
            }
        }

        System.out.println(count);

        in.close();
    }
}