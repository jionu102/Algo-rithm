import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] grid = new int[m][n];
        for (int[] arr : grid) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        markDropCount(grid, drops);
        grid = colSlidingWindow(grid, n, w);
        grid = rowSlidingWindow(grid, m, h);
        
        return bestCoordinate(grid);
    }
    
    private int[][] colSlidingWindow(int[][] grid, int n, int w) {
        int[][] result = new int[grid.length][n - w + 1];
        
        for (int r = 0; r < grid.length; r++) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            int[] tempArr = new int[n - w + 1];
            
            for (int c = 0; c < n; c++) {
                if (!queue.isEmpty() && queue.peekFirst() < c - w + 1) {
                    queue.pollFirst();
                }
                
                while (!queue.isEmpty() && grid[r][queue.peekLast()] > grid[r][c]) { 
                    queue.pollLast();
                }
                
                queue.offerLast(c);
                
                if (c >= w - 1) {
                    tempArr[c - w + 1] = grid[r][queue.peekFirst()];
                }
            }
            
            result[r] = tempArr;
        }
        
        return result;
    }
    
    private int[][] rowSlidingWindow(int[][] grid, int m, int h) {
        int[][] result = new int[m - h + 1][grid[0].length];
        
        for (int c = 0; c < grid[0].length; c++) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            
            for (int r = 0; r < m; r++) {
                // 범위를 벗어난 index 제거
                if (!queue.isEmpty() && queue.peekFirst() < r - h + 1) {
                    queue.pollFirst();
                }
                
                // 현재 값보다 큰 후보 제거
                while (!queue.isEmpty() && grid[queue.peekLast()][c] > grid[r][c]) { 
                    queue.pollLast();
                }
                
                queue.offerLast(r);
                
                if (r >= h - 1) {
                    result[r - h + 1][c] = grid[queue.peekFirst()][c];
                }
            }
        }
        
        return result;
    }
    
    private void markDropCount(int[][] grid, int[][] drops) {
        int count = 1;
        for (int[] drop : drops) {
            grid[drop[0]][drop[1]] = count++;
        }
    }
    
    private int[] bestCoordinate(int[][] grid) {
        int max = Integer.MIN_VALUE;
        int[] result = new int[2];
        
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (max < grid[r][c]) {
                    result[0] = r;
                    result[1] = c;
                    max = grid[r][c];
                }
            }
        }
        return result;
    }
}