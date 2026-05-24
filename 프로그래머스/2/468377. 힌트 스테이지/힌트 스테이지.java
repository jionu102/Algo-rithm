import java.util.*;

class Solution {
    
    private static final Map<String, Integer> memo = new HashMap<>();
    
    public int solution(int[][] cost, int[][] hint) {
        int answer = 0;
        
        for (int[] c : cost) {
            answer += c[0];
        }
        
        answer -= best(cost, hint, new int[cost.length], 0);
        
        return answer;
    }
    
    private int best(int[][] cost, int[][] hint, int[] indexArr, int depth) {
        if (depth == hint.length) {
            return 0;
        }
        
        String key = depth + Arrays.toString(indexArr);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int not = 0;
        not += best(cost, hint, indexArr, depth + 1);
        
        int buy = -hint[depth][0];
        for (int i = 1; i < hint[depth].length; i++) { 
            int row = hint[depth][i] - 1;
            int col = indexArr[row];
            
            if (col + 1 < cost[row].length) {
                buy += cost[row][col] - cost[row][col + 1];
            }
            indexArr[row]++;
        }
        
        buy += best(cost, hint, indexArr, depth + 1);
        
        for (int i = 1; i < hint[depth].length; i++) {
            indexArr[hint[depth][i] - 1]--;
        }
        
        int result = buy > not ? buy : not;
        
        memo.put(key, result);
        
        return result;
    }
}