import java.util.Scanner;

public class lis {
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int arr[]=new int[n];
    for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
    }

    int dp[]=new int[n];
    dp[0]=1;
    for(int i=1;i<dp.length;i++){
        if(arr[i]>=arr[i-1])
            dp[i]=dp[i-1]+1;
        else
            dp[i]=1;

    }
    int ans=0;
    for(int i=0;i<dp.length;i++){
        if(ans<dp[i])
            ans=dp[i];
    }
    System.out.println(ans);
    }
}
