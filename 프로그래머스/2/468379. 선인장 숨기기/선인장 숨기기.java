class Solution {

    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] grid = new int[m][n];
        Cactus cactus = new Cactus(h, w);
        int[] result = binarySearch(grid, drops, m, n, cactus);
        
        return result;
    }   
    
    private static int[] binarySearch(
        int[][] grid, int[][] drops, int m, int n, Cactus cactus
    ) {
        int min = 0;
        int max = drops.length;
        int[] result = new int[] {-1, -1};
        
        while (min <= max) {
            int mid = (min + max) / 2;
            int[] coordinate = check(drops, mid, m, n, cactus);
                
            if (coordinate != null) {
                min = mid + 1;
                result = coordinate;
            } else {
                max = mid - 1;
            }
        }
        
        return result;
    }
    
    private static int[] check(
        int[][] drops, int mid, int m, int n, Cactus cactus
    ) { 
        PrefixSum psum = new PrefixSum(m + 1, n + 1);
        psum.markDrop(drops, mid);
        psum.calculate();
        
        return psum.psumInCactus(cactus);
    }
    
    private static class Cactus {
        int height;
        int width;
        
        private Cactus(int height, int width) {
            this.height = height;
            this.width = width;
        }
        
        private int getHeight() {
            return height;
        }
        
        private int getWidth() {
            return width;
        }
    }
    
    private static class PrefixSum {
        int[][] psum;
        
        private PrefixSum(int r, int c) {
            this.psum = new int[r][c];
        }
        
        private void markDrop(int[][] drops, int mid) {
            for (int i = 0; i < mid; i++) {
                int r = drops[i][0];
                int c = drops[i][1];
                psum[r + 1][c + 1] = 1;
            }
        }
        
        private void calculate() {
            for (int r = 1; r < psum.length; r++) {
                for (int c = 1; c < psum[0].length; c++) {
                    psum[r][c] += psum[r - 1][c] + psum[r][c - 1] - psum[r - 1][c - 1];
                }
            }
        }
        
        private int[] psumInCactus(Cactus cactus) {
            int h = cactus.getHeight();
            int w = cactus.getWidth();
            
            for (int r = h; r < psum.length; r++) {
                for (int c = w; c < psum[0].length; c++) {
                    int num = psum[r - h][c] + psum[r][c - w] - psum[r - h][ c - w];
                    
                    if (psum[r][c] == num) {
                        return new int[]{r - h, c - w};
                    }
                }
            }
            
            return null;
        }
        
        private int[][] getPsum() {
            return psum;
        }
    }

}