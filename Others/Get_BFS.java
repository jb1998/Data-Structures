import java.util.*;

public class Get_BFS {

    static HashMap<Integer, Integer> hashMap;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        int iterate=0;
        while (iterate++<t){
            int V = s.nextInt();
            int E = s.nextInt();
            int arr[][] = new int[V+1][V+1];
            hashMap = new HashMap<>();
            for (int i = 1; i <= E; i++) {
                int start = s.nextInt();
                int end = s.nextInt();
                arr[start][end] = 1;
                arr[end][start] = 1;
            }
            int startpath=1;
            int endpath=V;
            boolean is_visited[]=new boolean[V+1];
            getbfs(startpath,endpath,arr,is_visited);
            ArrayList<Integer> arrayList=new ArrayList<>();
//        System.out.println(hashMap.toString());
            if(hashMap==null || !hashMap.containsKey(endpath)){
                System.out.println();
            }else{
                int top=hashMap.get(endpath);
                arrayList.add(endpath);

                while (top!=startpath){
                    arrayList.add(top);
                    top=hashMap.get(top);
                }
                arrayList.add(top);
//                for(int i=0;i<arrayList.size();i++){
                    System.out.println(arrayList.size()-1);
//                }
            }
        }


    }

    private static void getbfs(int startpath, int endpath, int[][] arr,  boolean[] is_visited) {
        Queue<Integer> queue= new LinkedList<>();
        queue.add(startpath);
        is_visited[startpath]=true;
        while (!queue.isEmpty()){
            int top=queue.peek();
            queue.remove(top);
            for(int i=0;i<arr.length;i++){


                if(arr[top][i]==1 && is_visited[i]==false){
                    queue.add(i);
                    hashMap.put(i,top);
//                    System.out.println(i+" "+top);
                    is_visited[i]=true;
                    if(i==endpath){
                        break;
                    }
                }
            }
        }
    }
}
