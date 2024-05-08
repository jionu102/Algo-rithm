import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[] score = new double[n];
        double maxScore = 0;
        double avg = 0;

        for (int i = 0; i < n; i++){
            score[i] = in.nextInt();
            if(score[i] > maxScore)
                maxScore = score[i];
        }
        for(int i = 0; i < n; i++){
            score[i]  *= 100 / maxScore;
            avg += score[i];
        }
        System.out.println(avg/n);
    }
}