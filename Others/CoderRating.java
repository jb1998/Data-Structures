import java.util.Scanner;

class Triplet{
    int x,y,index;
}
public class CoderRating {
   static Triplet[] arr;
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    arr=new Triplet[n];
    for(int i=0;i<n;i++){
        arr[i].x=sc.nextInt();
        arr[i].y=sc.nextInt();
        arr[i].index=i;
    }
    }
    public static void update(){

    }
    public static void query(){

    }
}
