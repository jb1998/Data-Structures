import java.util.Scanner;

public class Min_sub_array {
    static int size=0;
    static int segment[];
    public static void main(String args[]){
     Scanner sc = new Scanner(System.in);
     int n=sc.nextInt();
     size=n;
     int q=sc.nextInt();
     int arr[]=new int[n];
     for(int i=0;i<n;i++){
         arr[i]=sc.nextInt();
     }
     int iterate=0;
        segment=new int[size*2];
                make(1,0,n-1,arr);
//        for(int i=0;i<segment.length;i++){
//            System.out.print(segment[i]+" ");
//        }
     while(iterate++<q){
      char ch=sc.next().charAt(0);
      int l=sc.nextInt();
      int r=sc.nextInt();
      l--;
      r--;
      if(ch=='q'){
          System.out.println(query(1,0,n-1,l,r));
      }else{
          r++;
          update(arr,0,n-1,1,l,r);
//          for(int i=0;i<segment.length;i++){
//
//              System.out.print(segment[i]+" ");
//          }
      }
     }
}

    private static int query( int node, int startarr, int endarr,int startq,int endq) {
        if(endarr<startq || startarr>endq ){
            return Integer.MAX_VALUE;
        }
        if(startarr>=startq && endarr<=endq){
            return segment[node];
        }
        int mid=startarr+(endarr-startarr)/2;
        int ans1=query(node*2,startarr,mid,startq,endq);
        int ans2=query(node*2+1,mid+1,endarr,startq,endq);
        return Math.min(ans1,ans2);
    }

    private static void update( int[] arr, int start,int end, int node, int index, int value) {
    if(start==end)
    {
        arr[index]=value;
        segment[node]=value;
        return;
    }

    int mid=start+(end-start)/2;

        if(index>mid){
            update(arr,mid+1,end,2*node+1,index,value);
        }else
        update(arr,start,mid,2*node,index,value);

        segment[node]=Math.min(segment[node*2],segment[node*2+1]);

    }

    private static void make(int node,int arr_start, int arr_end, int[] arr) {

        if(arr_start==arr_end){
            segment[node]=arr[arr_start];
            return ;
        }
        int  mid=arr_start+(arr_end-arr_start)/2;

        make(node*2,arr_start,mid,arr);
        make(node*2+1,mid+1,arr_end,arr);
        segment[node]=Math.min(segment[node*2],segment[node*2+1]);
    }
}
