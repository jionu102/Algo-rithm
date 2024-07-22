import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        int[] dong = new int[T];
        int[] ho = new int[T];

        int maxDong = 0;
        int maxHo = 0;

        //사용자 입력 후 가장 큰 층과 호수 저장
        for(int i = 0; i < T; i++){
            dong[i] = in.nextInt();
            if(dong[i] > maxDong) maxDong = dong[i];
            ho[i] = in.nextInt();
            if(ho[i] > maxHo) maxHo = ho[i];
        }

        //아파트 배열
        int[][] apt = new int[maxDong + 1][maxHo + 1];

        //0층 필요한 만큼 초기화
        for(int i = 0; i < maxHo; i++){
            apt[0][i + 1] = i + 1;
        }

        for(int i = 1; i <= maxDong; i++){
            for(int j = 1; j <= maxHo; j++){
                apt[i][j] = aptValue(apt, i, j);
            }
        }
        for(int i = 0; i < T; i++) {
            System.out.println(apt[dong[i]][ho[i]]);
        }
    }
    public static int aptValue(int[][] apt, int a, int b){
        int sum = 0;
        for(int i = b; i > 0; i--){
            sum += apt[a-1][i];
        }
        return sum;
    }

}
