import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int c;
        try {
            c = reader.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(c);
    }
}
