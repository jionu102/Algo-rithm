import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        String[][] arr = new String[N][3];
        int rank = 0;

        for(int i = 0; i < N; i++){
            String line = in.readLine();
            String[] parts = line.split(" ");
            arr[i][0] = parts[0];
            arr[i][1] = parts[1];
            arr[i][2] = Integer.toString(rank++);
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                int numCompare = Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0]));
                if (numCompare == 0) {
                    return Integer.compare(Integer.parseInt(a[2]), Integer.parseInt(b[2]));
                }
                return numCompare;
            }
        });


        for(int i = 0; i < N; i++){
            System.out.print(arr[i][0] + " ");
            System.out.println(arr[i][1]);
        }
        in.close();
    }
}
