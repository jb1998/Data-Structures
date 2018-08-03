import java.util.Scanner;

//We’ll assign ‘A’ the code word 1, ‘B’ will be 2, and so on down to ‘Z’ being assigned 26.”
// find all such codes
public class Alpha {
    public static int mod=1000000007;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (true) {

            String temp =sc.next();
            if(temp.equals("0"))
                break;

            int arr[] = new int[temp.length()+1];
            arr[0]=1;
            arr[1]=1;
            for(int i=2;i<arr.length;i++){
                if(temp.charAt(i-1)!='0')
                    arr[i]=arr[i-1]%mod;

                if((((temp.charAt(i-2)-'0')*10+(temp.charAt(i-1)-'0'))<=26) && (((temp.charAt(i-2)-'0')*10+(temp.charAt(i-1)-'0'))>=10))
                arr[i]=((arr[i]%mod)+(arr[i-2]%mod))%mod;

            }
            System.out.println(arr[arr.length-1]);

        }
    }
}
