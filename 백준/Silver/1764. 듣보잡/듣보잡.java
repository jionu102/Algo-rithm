import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> check = new HashSet<>();
        List<String> doubleCheck = new ArrayList<>();

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            check.add(name);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (check.contains(name)) {
                doubleCheck.add(name);
            }
        }

        doubleCheck.sort(null);

        System.out.println(doubleCheck.size());

        for (String name : doubleCheck) {
            System.out.println(name);
        }

        br.close();
    }
}
