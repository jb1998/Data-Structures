import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Is_path {
    public static void main(String args[]){
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
        boolean is_visited[]=new boolean[V];
        BFS_(is_visited,0,arr);
        for(int i=0;i<arr.length;i++){
            if(is_visited[i]==false){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");

    }

    private static void BFS_(boolean[] is_visited, int ch_start, int[][] arr) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(ch_start);
        is_visited[ch_start]=true;
        while (!queue.isEmpty()){
            int top=queue.peek();
            queue.remove(top);
            for(int i=0;i<arr.length;i++){
                if(arr[top][i]==1 && is_visited[i]==false){
                    is_visited[i]=true;
                    queue.add(i);
                }
            }
        }
    }

}
