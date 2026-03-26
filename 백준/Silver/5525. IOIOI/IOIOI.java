import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.nextLine();
        int M = in.nextInt();
        in.nextLine();

        String str = in.nextLine();
        StringBuilder patternStr = new StringBuilder();
        patternStr.append("IOI");
        for (int i = 1; i < N; i++) {
            patternStr.append("OI");
        }

        int count = 0;

        int index = str.indexOf('I');;

        while (index <= str.length() - patternStr.length()) {
            int findIndex = str.indexOf(patternStr.toString(), index);
            if (findIndex != -1) {
                index = findIndex + 1;
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);

        in.close();
    }
}