class Solution {
    
    public int solution(int[][] cost, int[][] hint) {
        int answer = Integer.MAX_VALUE;
        
        int stages = cost.length;
        int buyCount = stages - 1;
        
        for (int caseNum = 0; caseNum < (1 << buyCount); caseNum++) {
            int total = 0;
            
            boolean[] notOrBuy = new boolean[buyCount];
            for (int i = 0; i < buyCount; i++) {
                notOrBuy[i] = (caseNum & (1 << i)) == 1 << i;
            }
            
            int[] hintCount = new int[stages];
            
            for (int i = 0; i < stages; i++) {
                int col = hintCount[i];
                if (col > cost[i].length - 1) col = cost[i].length - 1;
                total += cost[i][col];
                
                if (i < buyCount && notOrBuy[i]) {
                    total += hint[i][0];
                    
                    for (int j = 1; j < hint[i].length; j++) {
                        int hintStage = hint[i][j] - 1;
                        hintCount[hintStage]++;
                    }
                }
            }
            
            answer = answer > total ? total : answer;
        }
        
        return answer;
    }

}