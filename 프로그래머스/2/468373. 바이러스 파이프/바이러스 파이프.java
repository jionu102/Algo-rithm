import java.util.*;

class Solution {
    
    private static List<Integer>[] graphA;
    private static List<Integer>[] graphB;
    private static List<Integer>[] graphC;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        initGraph(n, edges);
        
        return dfs(new HashSet<>(Set.of(infection)), k, 0);
    }
    
    private int dfs(Set<Integer> infections, int k, int depth) {
        if (depth == k) {
            return infections.size();
        }
        
        int resultA = simulation(graphA, infections, k, depth);
        int resultB = simulation(graphB, infections, k, depth);
        int resultC = simulation(graphC, infections, k, depth);
        
        return Math.max(resultA, Math.max(resultB, resultC));
    }
    
    private int simulation(List<Integer>[] graph, Set<Integer> infections, int k, int depth) {
        List<Integer> memo = openPipe(graph, infections);
        
        int result = dfs(infections, k, depth + 1);
        
        rollback(infections, memo);
        
        return result;
    }
    
    private void rollback(Set<Integer> infections, List<Integer> memo) {
        for (int m : memo) {
            infections.remove(m);
        }
    }
    
    private List<Integer> openPipe(List<Integer>[] graph, Set<Integer> infections) {
        List<Integer> memo = new ArrayList<>();
        
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < graph.length; i++) {
            if (infections.contains(i) && !graph[i].isEmpty()) {
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int root = q.poll();
            
            for (int node : graph[root]) {
                if (!infections.contains(node)) {
                    q.offer(node);
                    memo.add(node);
                    infections.add(node);
                }
            }
        }
        
        return memo;
    }
    
    private void initGraph(int n, int[][] edges) {
        graphA = new ArrayList[n + 1];
        graphB = new ArrayList[n + 1];
        graphC = new ArrayList[n + 1];
        initList(graphA, edges, 1);
        initList(graphB, edges, 2);
        initList(graphC, edges, 3);
    }
    
    private void initList(List<Integer>[] graph, int[][] edges, int type) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            if (edge[2] == type) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }
        }
    }
}