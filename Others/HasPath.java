import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HasPath {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int arr[][]=new int[V][V];
        for(int i=0;i<E;i++){
            int start=s.nextInt();
            int end=s.nextInt();
            arr[start][end]=1;
            arr[end][start]=1;
        }
        int ch_start=s.nextInt();
        int ch_end=s.nextInt();
        boolean is_visited[]=new boolean[V];
       System.out.println(haspath(arr,ch_start,ch_end,is_visited));

    }

    private static boolean haspath(int[][] arr, int ch_start, int ch_end,boolean is_visited[]) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(ch_start);
        is_visited[ch_start]=true;
        while (!queue.isEmpty()){
            int top=queue.peek();
            if(top==ch_end){
                return true;
            }
            queue.remove(top);
            for(int i=0;i<arr.length;i++){
                if(arr[top][i]==1 && is_visited[i]==false){
                    queue.add(i);
                    is_visited[i]=true;




                }
            }
        }
        return false;
    }
}
