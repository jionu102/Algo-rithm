import java.util.Scanner;

public class Main {
    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        arr = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String s = in.next();
            for(int j = 0; j < m; j++){
                arr[i][j] = s.charAt(j) == 'W';
            }
        }

        int n_row = n - 7;
        int m_col = m - 7;
        for(int i = 0; i < n_row; i++){
            for(int j = 0; j < m_col; j++){
                chess(i,j);
            }
        }
        System.out.println(min);

    }

    private static void chess(int x, int y){
        int x_end = x + 8;
        int y_end = y + 8;
        int count = 0;

        boolean t = arr[x][y];

        for(int i = x; i < x_end; i++){
            for(int j = y; j < y_end; j++) {
                if (arr[i][j] != t) {
                    count++;
                }
                t = !t;
            }
            t = !t;
        }
        count = Math.min(count, 64-count);
        min = Math.min(min,count);
    }
}
