import java.util.List;
import java.util.LinkedList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        List<Integer> list = new LinkedList<>();

        int N = in.nextInt();

        for(int i = 1; i <= N; i++) {
            list.add(i);
        }


        while(list.size() > 1) {
            list.remove(0);	// 맨 앞의 원소 버림
            list.add(list.remove(0));	// 맨 앞의 원소를 버림과 동시에 버려진 원소를 맨 뒤에 삽입
        }

        System.out.println(list.get(0));	// 마지막으로 남은 원소 출력
    }
}