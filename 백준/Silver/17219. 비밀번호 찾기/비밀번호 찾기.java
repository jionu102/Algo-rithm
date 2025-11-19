import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] addressPasswordNum = in.readLine().split(" ");
        int savedAddressNum = Integer.parseInt(addressPasswordNum[0]);
        int findAddressNum = Integer.parseInt(addressPasswordNum[1]);

        Map<String, String> addressPasswordMap = new HashMap<>();
        for (int i = 0; i < savedAddressNum; i++) {
            String[] parts = in.readLine().split(" ");
            addressPasswordMap.put(parts[0], parts[1]);
        }

        for (int i = 0; i < findAddressNum; i++) {
            String address = in.readLine();
            String password = addressPasswordMap.get(address);
            System.out.println(password);
        }

        in.close();
    }
}