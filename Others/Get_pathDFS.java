import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Get_pathDFS {
    static boolean[] is_visited;

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
        int path_start=s.nextInt();
        int path_end=s.nextInt();
        is_visited=new boolean[V];

      ArrayList<Integer> arrayList=  getDFS(arr,path_start,path_end);
      if(arrayList==null){
          System.out.println();
      }else{

          for(int i=0;i<arrayList.size();i++){
              System.out.print(arrayList.get(i)+" ");
          }
      }
    }

    private static ArrayList<Integer> getDFS(int[][] arr, int path_start, int path_end) {
        if(path_end==path_start){
            ArrayList<Integer> arrayList=new ArrayList<>();
            arrayList.add(path_end);
            return arrayList;
        }
        is_visited[path_start]=true;

        for(int i=0;i<arr.length;i++){
            if(arr[path_start][i]==1 && is_visited[i]==false){
                ArrayList<Integer> small=getDFS(arr,i,path_end);
                if(small!=null){
                    small.add(path_start);
                    return small;
                }
            }
        }
      return null;
    }
}
