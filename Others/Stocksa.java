import java.util.Scanner;

public class Stocksa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();
        int x_i_1=0,x_i,c_i;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){

            x_i= (int) ((( (x_i_1) %m)*a + b )%(Math.pow(2,32)));
            c_i= (int) (x_i/(Math.pow(2,8)));

            if(c_i>ans){
                ans=c_i;
            }
            x_i_1=x_i;
        }
      System.out.println(ans);
    }
}
