import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String isbn = in.nextLine();

        int targetIndex = isbn.indexOf("*");
        boolean targetIsLast = targetIndex == isbn.length() - 1;
        boolean targetIsEven = targetIndex % 2 == 0;

        int evenSum = 0;
        for (int i = 0; i < isbn.length(); i += 2) {
            if (i == targetIndex) {
                continue;
            }
            evenSum += (int) isbn.charAt(i) - '0';
        }

        int oddSum = 0;
        for (int i = 1; i < isbn.length(); i += 2) {
            if (i == targetIndex) {
                continue;
            }
            oddSum += ((int) isbn.charAt(i) - '0') * 3;
        }
        
        int target = 0;
        if (targetIsEven) {
            for (int i = 0; i < 11; i++) {
                if ((evenSum + oddSum + i) % 10 == 0) {
                    target = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < 11; i++) {
                if ((evenSum + oddSum + i * 3) % 10 == 0) {
                    target = i;
                    break;
                }
            }
        }

        System.out.println(target);
        in.close();
    }
}