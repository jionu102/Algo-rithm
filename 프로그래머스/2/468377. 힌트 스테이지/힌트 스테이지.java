class Solution {
    
    public int solution(int[][] cost, int[][] hint) {
        int[] hintCount = new int[cost.length];
        
        int answer = dfs(cost, hint, hintCount, 0);
        
        return answer;
    }
    
    public int dfs(int[][] cost, int[][] hint, int[] hintCount, int depth) {      
        int c = hintCount[depth] > cost[depth].length - 1 
            ? cost[depth].length - 1
            : hintCount[depth];
        
        int notBuy = cost[depth][c];
        
        if (depth == hint.length) {
            return notBuy;
        }
        
        notBuy += dfs(cost, hint, hintCount, depth + 1);
        
        
        int buy = cost[depth][c] + hint[depth][0];
        for (int i = 1; i < hint[depth].length; i++) {
            hintCount[hint[depth][i] - 1]++;
        }
        buy += dfs(cost, hint, hintCount, depth + 1);
        
        for (int i = 1; i < hint[depth].length; i++) {
            hintCount[hint[depth][i] - 1]--;
        }
        
        return Math.min(buy, notBuy);
    }
}