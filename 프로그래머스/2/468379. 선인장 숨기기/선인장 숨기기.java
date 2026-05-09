import java.util.*;
import java.util.stream.*;

class Solution {

    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        List<Position> dropPositions = Arrays.stream(drops)
            .map(Position::fromArray)
            .collect(Collectors.toList());

        int gridRows = m - h + 1;
        int gridCols = n - w + 1;

        CoverageAnalyzer analyzer = new CoverageAnalyzer(gridRows, gridCols, h, w);
        SurvivalOptimizer optimizer = new SurvivalOptimizer(analyzer, dropPositions);

        return optimizer.findBestPosition();
    }

    private static class Position {
        private final int row;
        private final int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public static Position fromArray(int[] array) {
            return new Position(array[0], array[1]);
        }

        public int row() { return row; }
        public int col() { return col; }
    }

    /**
     * 2D 차분 배열을 이용해 첫 k개의 drop에 대해
     * 피격되지 않은 선인장 위치를 찾는다.
     */
    private static class CoverageAnalyzer {
        private final int gridRows;
        private final int gridCols;
        private final int cactusHeight;
        private final int cactusWidth;

        public CoverageAnalyzer(int gridRows, int gridCols,
                                int cactusHeight, int cactusWidth) {
            this.gridRows = gridRows;
            this.gridCols = gridCols;
            this.cactusHeight = cactusHeight;
            this.cactusWidth = cactusWidth;
        }

        /**
         * 첫 count개의 drop을 떨어뜨렸을 때,
         * 한 번도 맞지 않은 위치가 있으면 그 중 첫 번째를 반환.
         * 모두 맞았으면 null 반환.
         */
        public int[] findUncoveredPosition(List<Position> drops, int count) {
            int[][] diff = new int[gridRows + 1][gridCols + 1];

            // 각 drop이 영향을 주는 top-left 범위를 차분 배열에 O(1)로 마킹
            for (int i = 0; i < count; i++) {
                Position drop = drops.get(i);
                int minRow = Math.max(0, drop.row() - cactusHeight + 1);
                int maxRow = Math.min(gridRows - 1, drop.row());
                int minCol = Math.max(0, drop.col() - cactusWidth + 1);
                int maxCol = Math.min(gridCols - 1, drop.col());

                if (minRow > maxRow || minCol > maxCol) continue;

                diff[minRow][minCol]++;
                diff[minRow][maxCol + 1]--;
                diff[maxRow + 1][minCol]--;
                diff[maxRow + 1][maxCol + 1]++;
            }

            // 2D prefix sum 복원
            for (int i = 0; i < gridRows; i++) {
                for (int j = 1; j < gridCols; j++) {
                    diff[i][j] += diff[i][j - 1];
                }
            }
            for (int j = 0; j < gridCols; j++) {
                for (int i = 1; i < gridRows; i++) {
                    diff[i][j] += diff[i - 1][j];
                }
            }

            // 첫 번째 uncovered 위치 탐색 (행 우선)
            for (int i = 0; i < gridRows; i++) {
                for (int j = 0; j < gridCols; j++) {
                    if (diff[i][j] == 0) {
                        return new int[]{i, j};
                    }
                }
            }

            return null;
        }
    }

    /**
     * 이분탐색으로 최대 생존 수를 달성하는 위치를 찾는다.
     * "첫 k개 drop을 버틸 수 있는 위치가 존재하는가?"에 대해 탐색.
     */
    private static class SurvivalOptimizer {
        private final CoverageAnalyzer analyzer;
        private final List<Position> drops;

        public SurvivalOptimizer(CoverageAnalyzer analyzer, List<Position> drops) {
            this.analyzer = analyzer;
            this.drops = drops;
        }

        public int[] findBestPosition() {
            int lo = 0;
            int hi = drops.size();
            int[] bestPosition = {0, 0};

            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                int[] uncovered = analyzer.findUncoveredPosition(drops, mid);

                if (uncovered != null) {
                    bestPosition = uncovered;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            return bestPosition;
        }
    }
}