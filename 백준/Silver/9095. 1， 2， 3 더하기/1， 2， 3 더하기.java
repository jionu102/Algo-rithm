import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    private static Integer[] memory;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testNumber = in.nextInt();
        int[] testCases = new int[testNumber + 1];
        IntStream.range(1, testNumber + 1).forEach(i -> testCases[i] = in.nextInt());
        memory = new Integer[11];
        memory[1] = 1;
        memory[2] = 2;
        memory[3] = 4;

        IntStream.range(1, testNumber + 1).forEach(i ->
                System.out.println(findNumberCases(testCases[i])));

        in.close();
    }

    public static int findNumberCases(int targetNumber) {
        if (memory[targetNumber] == null) {
            memory[targetNumber] = findNumberCases(targetNumber - 1) +
                    findNumberCases(targetNumber - 2) +
                    findNumberCases(targetNumber - 3);
        }
        return memory[targetNumber];
    }
}
