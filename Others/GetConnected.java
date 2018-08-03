import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GetConnected {
    private static boolean[] is_visited;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int arr[][]=new int[V][V];
        for (int i=0;i<E;i++){
            int start=s.nextInt();
            int end=s.nextInt();
            arr[start][end]=1;
            arr[end][start]=1;
        }
        ArrayList<ArrayList<Integer>> final_arr=new ArrayList<>();
        is_visited=new boolean[V];
        for(int i=0;i<arr.length;i++){
            if(is_visited[i]==false){
                ArrayList<Integer> arrayLists=DFS(arr,i);
                Collections.sort(arrayLists,Collections.reverseOrder());
                    final_arr.add(arrayLists);
            }

        }
        for(int i=0;i<final_arr.size();i++){
            for(int j=final_arr.get(i).size()-1;j>=0;j--){
                System.out.print(final_arr.get(i).get(j)+" ");

            }
            System.out.println();
        }
    }

    private static ArrayList<Integer> DFS(int[][] arr, int start) {
        is_visited[start]=true;
        ArrayList<Integer> arrayList=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[start][i]==1 && is_visited[i]==false){
                is_visited[i]=true;
               ArrayList<Integer> small=DFS(arr,i);
                for(int j=0;j<small.size();j++){
                    arrayList.add(small.get(j));
                }


            }
        }
        arrayList.add(start);
        return arrayList;
    }
}
