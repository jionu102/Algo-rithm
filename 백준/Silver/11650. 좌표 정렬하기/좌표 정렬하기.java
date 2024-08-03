import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++){
            String line = in.readLine();
            String[] parts = line.split(" ");

            arr[i][0] = Integer.parseInt(parts[0]);
            arr[i][1] = Integer.parseInt(parts[1]);
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int numCompare = Integer.compare(o1[0], o2[0]);
                if(numCompare == 0){
                    numCompare = Integer.compare(o1[1], o2[1]);
                }
                return numCompare;
            }
        });

        for(int i = 0; i < N; i++){
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
        in.close();
    }
}
