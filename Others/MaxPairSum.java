import java.util.Scanner;

class pair{
    int max;
    int smax;
    pair(){
        this.max=0;
        this.smax=0;
    }
}
public class MaxPairSum {
    static int size;
    static pair[] segment;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        size=3*n;

        segment=new pair[size];
       make(1,0,n-1,arr);
       for(int i=0;i<3*n;i++){
           System.out.println("Max : "+segment[i].max +" Smax : "+segment[i].smax);
        }

//        int q=sc.nextInt();
//
//        int iterate=0;
//        while(iterate<q){
//
//        }
    }
    public static void make(int segment_node,int start,int end,int arr[]){
        if(start==end){
            pair x=new pair();
            x.smax=Integer.MIN_VALUE;
            x.max=arr[start];
            segment[segment_node]=x;
//            segment[segment_node].5
//            max=arr[start];
//            segment[segment_node].smax=Integer.MIN_VALUE;
//            System.out.println(segment[segment_node]);
            return;
        }
        int mid=start+(end-start)/2;
        make(segment_node*2,start,mid,arr);
        make(segment_node*2+1,mid+1,end,arr);
        segment[segment_node].max=Math.max(segment[segment_node*2].max,segment[segment_node*2+1].max);
        segment[segment_node].smax=Math.min(Math.max(segment[segment_node*2].max,segment[segment_node*2+1].smax),Math.max(segment[segment_node*2+1].max,segment[segment_node*2].smax));


    }
}
