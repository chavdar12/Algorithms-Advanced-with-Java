import java.util.Scanner;

public class AbaspaBasapa {

    public static int[][] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String first = sc.nextLine();
        String second = sc.nextLine();

        dp = new int[first.length()][second.length()];

        int bestLength = 0;
        int bestRow = -1;

        for (int rowIndex = 0; rowIndex < first.length(); rowIndex++) {

            for (int colIndex = 0; colIndex < second.length(); colIndex++) {

                if (first.charAt(rowIndex) == second.charAt(colIndex)) {

                    dp[rowIndex][colIndex] = getPrevBest(rowIndex, colIndex) + 1;
                }

                if (dp[rowIndex][colIndex] > bestLength) {

                    bestLength = dp[rowIndex][colIndex];
                    bestRow = rowIndex;
                }
            }
        }

        System.out.println(first.substring(bestRow - bestLength + 1, bestRow + 1));
    }

    private static int getPrevBest(int rowIndex, int colIndex) {

        if (rowIndex - 1 < 0 || colIndex - 1 < 0) {

            return 0;
        }

        return dp[rowIndex - 1][colIndex - 1];
    }
}