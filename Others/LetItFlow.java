import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class LetItFlow {
    static int count = 0;

    static int mod = 1000000007;
    static boolean[][] isvisited;
    static int[][][] dp;
//    static int[][] dp2;

    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("sa2.txt"));

        PrintStream o = new PrintStream(new File("test.txt"));
        PrintStream console = System.out;
        System.setOut(o);
        int t = sc.nextInt();
        int iterate = 0;
        while (iterate++ < t) {
            count = 0;
            int n = sc.nextInt();
            String a = sc.next();
            String b = sc.next();
            String c = sc.next();
            dp = new int[3][n][2];
//            dp2 = new int[3][n];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < n; j++) {
                   for(int k=0;k<2;k++){
                       dp[i][j][k] = -1;

                   }
                                    }
            }
            isvisited = new boolean[3][n];
            int sum = helper(a, b, c, 0, 0, 0, n);
            System.out.println("******************************   " + sum);

            System.out.println(dp[0][0][0]);
        }



        System.setOut(console);
    }


    private static int helper(String a, String b, String c, int row, int column, int move, int n) {
        if (row >= 3 || row < 0 || column >= n || column < 0)
            return 0;
        if (column == n - 1 && row == 2 && move == 1 && c.charAt(column) == '.') {
            dp[row][column][move]=1;
            return 1;
        }
        int ans = 0;
        if ( dp[row][column][move] != -1) {
         return dp[row][column][move];
        } else{
            int sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;

            if (move == 0) {
                if (row >= 0 && row <= 2 && column >= 0 && column < n && isvisited[row][column] == false && ((row == 0 && a.charAt(column) == '.') || (row == 1 && b.charAt(column) == '.') || (row == 2 && c.charAt(column) == '.'))) {

                    isvisited[row][column] = true;
                    sum1 = helper(a, b, c, row - 1, column, 1, n);

                    sum2 = helper(a, b, c, row + 1, column, 1, n);
                    isvisited[row][column] = false;
                    dp[row][column][move] = (sum1 + sum2) % mod;
                }

                ans = (sum1 + sum2) % mod;


            } else {
                if (row >= 0 && row <= 2 && column >= 0 && column < n && isvisited[row][column] == false && ((row == 0 && a.charAt(column) == '.') || (row == 1 && b.charAt(column) == '.') || (row == 2 && c.charAt(column) == '.'))) {
                    isvisited[row][column] = true;
                    sum3 = helper(a, b, c, row, column - 1, 0, n);
                    sum4 = helper(a, b, c, row, column + 1, 0, n);
                    isvisited[row][column] = false;
                    ans = (sum3 + sum4) % mod;
                    dp[row][column][move] = ans;
                }


            }
        }

        return ans;
    }


}

