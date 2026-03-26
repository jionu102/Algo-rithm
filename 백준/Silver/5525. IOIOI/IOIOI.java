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

        int index = str.indexOf('I');;

        while (index <= str.length() - patternStr.length()) {
            int findIndex = str.indexOf(patternStr.toString(), index);
            if (findIndex != -1) {
                index = findIndex + 1;
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);

        in.close();
    }
}