import java.util.*;

class Solution {
    
    List<Integer>[] pipeA;
    List<Integer>[] pipeB;
    List<Integer>[] pipeC;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        pipeA = new ArrayList[n + 1];
        pipeB = new ArrayList[n + 1];
        pipeC = new ArrayList[n + 1];
        buildPipe(1, pipeA, edges);
        buildPipe(2, pipeB, edges);
        buildPipe(3, pipeC, edges);
        
        boolean[] infections = new boolean[n + 1];
        infections[infection] = true;
    
        return dfs(infections, k, 0);
    }
    
    private int dfs(boolean[] infections, int k, int depth) {
        if (depth == k) {
            return isTrueSize(infections);
        }

        int resultA = openPipe(infections, pipeA, k, depth);
        int resultB = openPipe(infections, pipeB, k, depth);
        int resultC = openPipe(infections, pipeC, k, depth);
        
        return Math.max(resultA, Math.max(resultB, resultC));
    }
    
    private int openPipe(boolean[] infections, List<Integer>[] pipe, int k, int depth) {
        List<Integer> memo = bfs(infections, pipe);
        
        int result = dfs(infections, k, depth + 1);
        
        rollback(infections, memo);
        
        return result;
    }
    
    private int isTrueSize(boolean[] infections) {
        int count = 0;
        for (boolean infection : infections) {
         if (infection) count++;
        }
        
        return count;
    }
    
    private void rollback(boolean[] infections, List<Integer> memo) {
        for (int m : memo) {
            infections[m] = false;
        }
    }
    
    private List<Integer> bfs(boolean[] infections, List<Integer>[] pipe) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < pipe.length; i++) {
            if (infections[i] && !pipe[i].isEmpty()) {
                queue.offer(i);
            }
        }
        
        List<Integer> memo = new ArrayList<>();
            
        while(!queue.isEmpty()) {
            int root = queue.poll();
            for (int node : pipe[root]) {
                // infections 가 visited 역할 수행
                if (infections[root] && !infections[node]) {
                    infections[node] = true;
                    queue.offer(node);
                    memo.add(node);
                }
            }
        }
        
        return memo;
    }
    
    private void buildPipe(int type, List<Integer>[] pipe, int[][] edges) {
        initPipe(pipe);
        
        for(int[] edge : edges) {
            if (edge[2] == type) {
                pipe[edge[0]].add(edge[1]);
                pipe[edge[1]].add(edge[0]);
            }
        }
    }
    
    private void initPipe(List<Integer>[] pipe) {
        for(int i = 0; i < pipe.length; i++) {
            pipe[i] = new ArrayList<>();
        }
    }
}