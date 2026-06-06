class Solution {
    
    public int solution(int n, int infection, int[][] edges, int k) {
        int[] infections = new int[n + 1];
        infections[infection]++;
        int startA = find(1, infections, edges, k, 0);
        int startB = find(2, infections, edges, k, 0);
        int startC = find(3, infections, edges, k, 0);
        
        return Math.max(startA, Math.max(startB, startC));
    }
    
    private int find(int type, int[] infections, int[][] edges, int k, int depth) {
        if (depth == k) {
            return biggerZeroSize(infections);
        }
        
        int[] memo = new int[infections.length];
        
        boolean changed;

        do {
            changed = false;

            for (int[] edge : edges) {
                if (edge[2] != type) continue;

                int a = edge[0];
                int b = edge[1];

                if (infections[a] > 0 && infections[b] == 0) {
                    infections[b]++;
                    memo[b]++;
                    changed = true;
                }

                if (infections[b] > 0 && infections[a] == 0) {
                    infections[a]++;
                    memo[a]++;
                    changed = true;
                }
            }
        } while (changed);
        
        // A 선택
        int resultA = find(1, infections, edges, k, depth + 1);
        // B 선택
        int resultB = find(2, infections, edges, k, depth + 1);
        // C 선택
        int resultC = find(3, infections, edges, k, depth + 1);
        
        rollback(infections, memo);
        
        return Math.max(resultA, Math.max(resultB, resultC));
    }
    
    private int biggerZeroSize(int[] infections) {
        int count = 0;
        
        for (int infection : infections) {
            if (infection > 0) count++;
        }
        
        return count;
    }
    
    private void rollback(int[] infection, int[] memo) {
        for (int i = 0; i < memo.length; i++) {
            infection[i] -= memo[i];
        }
    }
}