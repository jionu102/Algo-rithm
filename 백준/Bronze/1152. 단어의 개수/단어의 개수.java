import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        while (s.length() > 1000000 || !sMethod(s)) {
            s = scanner.nextLine();
        }
        if(s.equals(" ")) System.out.println(0);
        else {
            s = s.trim();
            String[] arr = s.split(" ");
            System.out.println(arr.length);
            scanner.close();
        }
    }

    private static boolean sMethod(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ' ' && s.charAt(i + 1) == ' ') return false;
        }
        return true;
    }
}