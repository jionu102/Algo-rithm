import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int N = Integer.parseInt(S);


        Set<Integer> NS = new TreeSet<>();

        for(int i = 0; i < N; i++){
            NS.add(Integer.parseInt(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        for(Integer num : NS){
            sb.append(num).append("\n");
        }

        System.out.println(sb.toString());
        br.close();
    }
}
