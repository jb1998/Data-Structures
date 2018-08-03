import java.util.ArrayList;
import java.util.Scanner;

public class Codechef {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int iterate=0;
        int t=sc.nextInt();
        while(iterate++<t){
         int n=sc.nextInt();
         int arr[]=new int[n];
         for(int i=0;i<n;i++){
             arr[i]=sc.nextInt();
         }
            ArrayList<Integer> sie=sieve();
            ArrayList<Integer> arr2=new ArrayList<>();
         for(int i=0;i<n;i++){
             int sum=0;
             for(int j=0;j<sie.size();j++){
                 if(sie.get(j)>arr[i]){
                     arr2.add(sum);
                     break;
                 }
                 if(arr[i]%sie.get(j)==0){
                     sum+=sie.get(j);
                 }
             }
         }
         int myans=0;
         for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 if(i!=j){
                     if(arr[j]%arr[i]==0 && arr2.get(j)%arr2.get(i)==0){
                     myans++;
                     }
                 }
             }
         }
         System.out.println(myans);
        }
    }

    private static boolean isprime(int b) {
        for(int i=2;i*i<=b;i++)
        {
            if(b%i==0)
            {
                return false;
            }
        }
        return true;
    }
    public static ArrayList<Integer> sieve()
    {
        int n=1000000;
        boolean arr[]=new boolean[n+1];
        for(int i=0;i<=n;i++)
        {
            arr[i]=true;
        }
        arr[0]=false;
        arr[1]=false;
        for(int i=2;i*i<=n;i++)
        {
            if(arr[i]==true)
            {
                if(isprime(i))
                {
                    for(int j=2*i;j<=n;j+=i)
                    {
                        arr[j]=false;
                    }
                }
            }
        }
        ArrayList<Integer> prime_list=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            if(arr[i]==true)
                prime_list.add(i);
        }
        return prime_list;
    }
}
