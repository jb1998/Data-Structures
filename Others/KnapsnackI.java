import java.util.Scanner;

public class KnapsnackI {
    public static int knapsack(int[] weight, int value[], int maxWeight) {
        int dp[][] = new int[value.length + 1][maxWeight + 1];

        for (int i = 1; i <= value.length; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                dp[i][j] = dp[i - 1][j];
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max((value[i - 1] + dp[i - 1][j - weight[i - 1]]), dp[i - 1][j]);
                }
            }

        }
        return dp[value.length][maxWeight];
    }

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int W=sc.nextInt();
        int n=sc.nextInt();
        int wt[]=new int[n];
        int val[]=new int[n];
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
            val[i]=sc.nextInt();
        }

        System.out.println(knapsack(wt,val,W));
    }
}
