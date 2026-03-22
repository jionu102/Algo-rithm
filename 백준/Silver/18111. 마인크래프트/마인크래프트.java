import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int time = Integer.MAX_VALUE;
    private static int z = Integer.MIN_VALUE;
    private static int inventory;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        inventory = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int[][] floor = new int[x][y];

        for (int i = x - 1; i >= 0; i--) {
            st = new StringTokenizer(in.readLine());

            for (int j = 0; j < y; j++) {
                floor[i][j] = Integer.parseInt(st.nextToken());

                if (floor[i][j] > max) {
                    max = floor[i][j];
                }

                if (floor[i][j] < min) {
                    min = floor[i][j];
                }
            }
        }

        blockSetting(floor, max, min);
        System.out.println(time + " " + z);
        in.close();
    }

    // 조건: 최소 시간이 걸리는 방법, 같을 경우 땅의 높이가 높은 것
    public static void blockSetting(int[][] floor, int max, int min) {
        int targetZ = max;
        while (targetZ >= min) {
            int tempTime = 0;
            int tempInventory = inventory;

            for (int i = 0; i < floor.length; i++) {
                for (int j = 0; j < floor[0].length; j++) {
                    if (targetZ > floor[i][j]) {
                        int updatedBlockNumber = targetZ - floor[i][j];
                        tempInventory -= updatedBlockNumber;
                        tempTime += 1 * updatedBlockNumber;
                    } else if (targetZ < floor[i][j]) {
                        int updatedBlockNumber = floor[i][j] - targetZ;
                        tempInventory += updatedBlockNumber;
                        tempTime += 2 * updatedBlockNumber;
                    }
                }
            }

            if (tempInventory >= 0) {
                if (tempTime < time) {
                    time = tempTime;
                    z = targetZ;
                }
            }
            targetZ--;
        }
    }
}