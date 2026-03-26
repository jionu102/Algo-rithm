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

        int index = str.indexOf('I');
        int count = 0;

        while (str.length() - index - patternStr.length() >= 0) {
            if (str.charAt(index) == 'I') {
                String temp = str.substring(index, index + patternStr.length());
                if (temp.equals(patternStr.toString())) {
                    count++;
                    index += 2;
                    continue;
                }
            }
            index += 1;
        }

        System.out.println(count);

        in.close();
    }
}