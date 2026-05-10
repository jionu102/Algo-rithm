import java.util.*;
import java.util.stream.*;

class Solution {

    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] grid = new int[m][n];
        GridUtil.fillGrid(grid, Integer.MAX_VALUE);
        GridUtil.numberGrid(grid, drops);
        
        Cactus cactus = new Cactus(w, h);

        grid = GridUtil.foldCols(grid, cactus);
        grid = GridUtil.foldRows(grid, cactus);
        
        return bestCoordinate(grid);
    }
    
    private static class Cactus {
        private final int width;
        private final int height;
        
        public Cactus(int width, int height) {
            this.width = width;
            this.height = height;
        }
        
        public int width() {
            return width;
        }
        
        public int height() {
            return height;
        }
    }
    
    private static class GridUtil {
        
        public static void fillGrid(int[][] grid, int value) {
            for (int[] arr : grid) {
                Arrays.fill(arr, value);
            }
        }
        
        public static void numberGrid(int[][] grid, int[][] coordinates) {
            for (int i = 0; i < coordinates.length; i++) {
                int row = coordinates[i][0];
                int col = coordinates[i][1];
                grid[row][col] = i;
            }
        }
        
        public static int[][] foldCols(int[][] grid, Cactus cactus) {
            int[][] result = new int[grid.length][grid[0].length - cactus.width() + 1];
            for (int i = 0; i < grid.length; i++) {
                result[i] = foldCol(grid, i, cactus);
            }
            
            return result;
        }
        
        private static int[] foldCol(int[][] grid, int row, Cactus cactus) {
            int[] target = grid[row];
            int[] result = new int[target.length - cactus.width() + 1];
            
            Deque<Integer> dq = new ArrayDeque<>();
                
            for (int c = 0; c < target.length; c++) {
                if (!dq.isEmpty() && dq.peekFirst() < c - cactus.width() + 1) {
                    dq.pollFirst();
                }
                
                while (!dq.isEmpty() && target[dq.peekLast()] >= target[c]) {
                    dq.pollLast();
                }
                
                dq.addLast(c);
                
                if (c >= cactus.width() - 1) {
                    result[c - cactus.width() + 1] = target[dq.peekFirst()];
                }
            }
            
            return result;
        }
        
        public static int[][] foldRows(int[][] grid, Cactus cactus) {
            int[][] result = new int[grid.length - cactus.height() + 1][grid[0].length];
            
            for (int i = 0; i < grid[0].length; i++) {
                Deque<Integer> dq = new ArrayDeque<>();
                
                for (int r = 0; r < grid.length; r++) {
                    if (!dq.isEmpty() && dq.peekFirst() < r - cactus.height() + 1) {
                        dq.pollFirst();
                    }    
                
                    while (!dq.isEmpty() && grid[dq.peekLast()][i] >= grid[r][i]) {
                        dq.pollLast();
                    }
                
                    dq.addLast(r);
                
                    if (r >= cactus.height() - 1) {
                        result[r - cactus.height() + 1][i] = grid[dq.peekFirst()][i];
                    }
                }
            }
            
            return result;
        }   
    }
    
    private int[] bestCoordinate(int[][] grid) {
        int max = Integer.MIN_VALUE;
        int[] coordinate = new int[2];
        
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] > max) {
                    max = grid[r][c];
                    coordinate[0] = r;
                    coordinate[1] = c;
                }
            }
        }
    
        return coordinate;
    }
    
}