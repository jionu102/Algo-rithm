import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<String> strarr = new ArrayList<>();
        String str;
        while(true){
            str = in.nextLine();
            strarr.add(str);
            if(str.equals("0")){
                strarr.remove(strarr.size()-1);
                break;
            }
        }
        for (String s : strarr) {
            if (strCheck(s)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean strCheck(String str){
        StringBuilder strT = new StringBuilder();
        for(int i = str.length()-1; i >= 0; i--){
            strT.append(str.charAt(i));
        }
        return strT.toString().equals(str);
    }
}
