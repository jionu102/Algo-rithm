import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int r = in.nextInt();
        int c = in.nextInt();

        int size = (int) Math.pow(2, N);
        int count = 0;
        count = find(size, r, c, count);

        System.out.println(count);

        in.close();
    }

    private static int find(int size, int r, int c, int count) {
        if (size == 1) {
            return count;
        }

        if (r < size / 2 && c < size / 2) {
            return find(size / 2, r, c, count);
        } else if (r < size / 2 && c >= size / 2) {
            count += size * size / 4 * 1;
            return find(size / 2, r, c - size / 2, count);
        } else if (r >= size / 2 && c < size / 2) {
            count += size * size / 4 * 2;
            return find(size / 2, r - size / 2, c, count);
        } else {
            count += size * size / 4 * 3;
            return find(size / 2, r - size / 2, c - size / 2, count);
        }
    }
}