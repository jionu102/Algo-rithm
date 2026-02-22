import java.util.Scanner;

public class Main {

    private static int[] trees;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int treeNumber = in.nextInt();
        int treeLength = in.nextInt();
        in.nextLine();

        trees = new int[treeNumber];
        int maxLengthTree = 0;

        for (int i = 0; i < trees.length; i++) {
            trees[i] = in.nextInt();
            if (trees[i] > maxLengthTree) {
                maxLengthTree = trees[i];
            }
        }

        int height = findMaxHeight(treeLength, maxLengthTree);
        System.out.println(height);

        in.close();
    }

    private static int findMaxHeight(int targetTreeLength, int maxLengthTree) {
        int x = maxLengthTree / 2;
        int h = x;

        while (true) {
            long treeLength = cutTrees(h);

            if (x < 2 || treeLength == targetTreeLength) {
                if (treeLength >= targetTreeLength) {
                    while (true) {
                        h += 1;
                        treeLength = cutTrees(h);
                        if (treeLength < targetTreeLength) {
                            return h - 1;
                        }
                    }
                } else {
                    while (true) {
                        h -= 1;
                        treeLength = cutTrees(h);
                        if (treeLength >= targetTreeLength) {
                            return h;
                        }
                    }
                }
            }

            if (treeLength >= targetTreeLength) {
                x = x / 2;
                h = h + x;
            } else {
                x = x / 2;
                h = h - x;
            }
        }
    }

    private static long cutTrees(int height) {
        long sum = 0;
        for (int tree : trees) {
            if (tree > height) {
                sum += tree - height;
            }
        }

        return sum;
    }
}